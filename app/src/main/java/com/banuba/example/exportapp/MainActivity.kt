package com.banuba.example.exportapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Size
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.banuba.sdk.core.AspectRatio
import com.banuba.sdk.core.Rotation
import com.banuba.sdk.core.effects.IVisualEffectDrawable
import com.banuba.sdk.core.ext.copyFromAssetsToExternal
import com.banuba.sdk.core.ext.isNullOrEmpty
import com.banuba.sdk.core.media.DurationExtractor
import com.banuba.sdk.export.data.ExportFlowManager
import com.banuba.sdk.ve.data.ExportMusicParams
import com.banuba.sdk.ve.data.ExportResult
import com.banuba.sdk.ve.data.ExportTaskParams
import com.banuba.sdk.ve.domain.VideoRangeList
import com.banuba.sdk.ve.domain.VideoRecordRange
import com.banuba.sdk.ve.effects.Effects
import com.banuba.sdk.ve.effects.RectParams
import com.banuba.sdk.ve.effects.SpeedTimedEffect
import com.banuba.sdk.ve.effects.VisualTimedEffect
import com.banuba.sdk.ve.effects.`object`.GifObjectDrawable
import com.banuba.sdk.ve.effects.`object`.TextObjectDrawable
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import java.io.File
import java.util.Stack
import java.util.UUID

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val backgroundExportFlowManager: ExportFlowManager by inject(named("backgroundExportFlowManager"))
    private val foregroundExportFlowManager: ExportFlowManager by inject(named("foregroundExportFlowManager"))

    private var isBackgroundExport = true

    private var exportResultVideoUri = Uri.EMPTY

    private val getPredefinedVideos = registerForActivityResult(
        ActivityResultContracts.GetMultipleContents()
    ) { videosUri ->
        if (videosUri.isNullOrEmpty()) return@registerForActivityResult

        progressVisible(true)

        val videoRanges = generateVideoRangeList(videosUri)

        val effects = generateEffects()

        val emptyMusicParams = ExportMusicParams(emptyList(), 0f)

        val coverFrameSize = Size(720, 1080)

        val exportTaskParams = ExportTaskParams(
            videoRanges = videoRanges,
            effects = effects,
            exportMusicParams = emptyMusicParams,
            coverFrameSize = coverFrameSize,
            aspect = AspectRatio.DEFAULT        //AspectRatio.DEFAULT == AspectRatio(9.0 / 16)
        )

        if (isBackgroundExport) {
            backgroundExportFlowManager.startExport(exportTaskParams)
        } else {
            foregroundExportFlowManager.startExport(exportTaskParams)
        }
    }

    private val exportResultObserver = Observer<ExportResult> { exportResult ->
        when (exportResult) {
            is ExportResult.Inactive, is ExportResult.Stopped -> progressVisible(false)

            is ExportResult.Progress -> {
                previewImageView.setImageURI(exportResult.preview)
                progressVisible(true)
            }

            is ExportResult.Success -> {
                progressVisible(false)
                exportResultVideoUri = exportResult.videoList.first().sourceUri
                Toast.makeText(
                    this,
                    "Export Success: ${exportResult.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            is ExportResult.Error -> {
                progressVisible(false)
                Toast.makeText(
                    this,
                    getString(exportResult.type.messageResId),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        backgroundExportFlowManager.resultData.observe(this, exportResultObserver)
        foregroundExportFlowManager.resultData.observe(this, exportResultObserver)

        backgroundExportBtn.setOnClickListener {
            pickPredefinedVideos(true)
        }

        foregroundExportBtn.setOnClickListener {
            pickPredefinedVideos(false)
        }

        stopExportBtn.setOnClickListener {
            exportResultVideoUri = Uri.EMPTY
            if (isBackgroundExport) {
                backgroundExportFlowManager.stopExport()
            } else {
                foregroundExportFlowManager.stopExport()
            }
        }

        previewImageView.setOnClickListener {
            if (exportResultVideoUri.isNullOrEmpty()) return@setOnClickListener
            openVideo(exportResultVideoUri)
        }
    }

    /**
     * You can set custom video ranges for your purposes. This requires
     * playFromMs and playToMs arguments to be set when creating the VideoRecordRange object.
     * Code below uses a range from 0 to video length for each video.
     */
    private fun generateVideoRangeList(videosUri: List<Uri>): VideoRangeList {
        val videoRecords = videosUri.map { fileUri ->
            val videoDuration = DurationExtractor().extractDurationMilliSec(this, fileUri)
            val videoSpeed = 1f
            VideoRecordRange(
                sourceUri = fileUri,            //mandatory, uri of video file
                durationMs = videoDuration,     //mandatory, duration of video
                speed = videoSpeed,             //mandatory, video playback speed
                playFromMs = 0,                 //optional, by default equals 0
                playToMs = videoDuration,       //optional, by default equals duration of video,
                rotation = Rotation.ROTATION_0  //optional, by default ROTATION_0
            )
        }
        return VideoRangeList(videoRecords)
    }

    /**
     * Effects are generated that are applied to the video. The code below
     * creates two visual effects: text and gif. Both effects are applied to the entire length
     * of the video.
     */
    private fun generateEffects(): Effects {
        val effectText = createTextVisualEffect()
        val effectGif = createGifVisualEffect()

        // Visual effects i.e. VHS, Glitch are not fully supported yet
        val visualStack = Stack<VisualTimedEffect>().apply {
            add(VisualTimedEffect.getFullRange(effectText))
            add(VisualTimedEffect.getFullRange(effectGif))
        }

        //Use empty stack because speed effects are not fully supported yet.
        val empty = Stack<SpeedTimedEffect>()

        return Effects(
            visualStack = visualStack,
            speedStack = empty
        )
    }

    /**
     * Creates a text effect. The text is created using a canvas and converted to a bitmap.
     * RectParams are used to set the coordinates, size, scale and rotation of the effect.
     */
    private fun createTextVisualEffect(): IVisualEffectDrawable {
        val bitmap = Bitmap.createBitmap(800, 150, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.textSize = 64f
        canvas.drawText("Hello, World!", 0f, 60f, paint)

        val rectParams = RectParams().apply {
            setCoordinates(150f, 300f, bitmap.width.toFloat(), bitmap.height.toFloat(), 0.8f, 0f)
        }

        return TextObjectDrawable(UUID.randomUUID(), bitmap, rectParams)
    }

    /**
     * Creates a gif(sticker) effect. Gif file must be downloaded to be used as an effect.
     * The code below uses gif from assets.
     * RectParams are used to set the coordinates, size, scale and rotation of the bitmap.
     */
    private fun createGifVisualEffect(): IVisualEffectDrawable {
        val stickerUri = copyFromAssetsToExternal("example.gif").toUri()

        val rectParams = RectParams().apply {
            setCoordinates(200f, 700f, 361f, 277f, 1f, 20f)
        }

        return GifObjectDrawable(UUID.randomUUID(), stickerUri, rectParams)
    }


    private fun RectParams.setCoordinates(
        x: Float,
        y: Float,
        width: Float,
        height: Float,
        scale: Float,
        rotation: Float
    ) {
        val points = floatArrayOf(
            x, y,
            x + width, y,
            x, y + height,
            x + width, y + height
        )
        Matrix().apply {
            reset()
            postScale(scale, scale, x + width / 2, y + height / 2)
            postRotate(rotation, x + width / 2, y + height / 2)
            mapPoints(points)
        }
        set(
            points[0], points[1],
            points[2], points[3],
            points[4], points[5],
            points[6], points[7]
        )
    }

    private fun pickPredefinedVideos(isBackground: Boolean) {
        previewImageView.setImageURI(null)
        isBackgroundExport = isBackground
        getPredefinedVideos.launch("video/*")
    }

    private fun progressVisible(isExporting: Boolean) {
        if (!isBackgroundExport) {
            exportProgressView.isVisible = isExporting
        }
        backgroundExportBtn.isEnabled = !isExporting
        foregroundExportBtn.isEnabled = !isExporting
    }

    private fun openVideo(videoUri: Uri) {
        videoUri.encodedPath?.let { encodedPath ->
            val intent = Intent(Intent.ACTION_VIEW).apply {
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                val uri = FileProvider.getUriForFile(
                    applicationContext,
                    "$packageName.provider",
                    File(encodedPath)
                )
                setDataAndType(uri, "video/mp4")
            }
            startActivity(intent)
        }
    }
}