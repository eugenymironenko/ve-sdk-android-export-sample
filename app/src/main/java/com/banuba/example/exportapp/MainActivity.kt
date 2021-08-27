package com.banuba.example.exportapp

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
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.banuba.sdk.core.AspectRatio
import com.banuba.sdk.core.effects.IVisualEffectDrawable
import com.banuba.sdk.core.ext.copyFromAssetsToExternal
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
import java.util.Stack
import java.util.UUID

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val exportFlowManger: ExportFlowManager by inject()

    private val getPredefinedVideos = registerForActivityResult(
        ActivityResultContracts.GetMultipleContents()
    ) { videosUri ->
        progressVisible(true)

        if (videosUri.isNullOrEmpty()) return@registerForActivityResult

        val videoRanges = generateVideoRangeList(videosUri)

        val effects = generateEffects()

        exportFlowManger.startExport(
            ExportTaskParams(
                videoRanges = videoRanges,
                effects = effects,
                exportMusicParams = ExportMusicParams(emptyList(), 0f),
                coverFrameSize = Size(720, 1080),
                singleSlideshowSourcePath = null,
                aspect = AspectRatio.DEFAULT
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exportFlowManger.resultData.observe(this, Observer { exportResult ->

            when (exportResult) {
                is ExportResult.Inactive, is ExportResult.Stopped -> progressVisible(false)

                is ExportResult.Progress ->  progressVisible(true)

                is ExportResult.Success -> {
                    progressVisible(false)
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
        })

        exportBtn.setOnClickListener {
            pickPredefinedVideos()
        }
    }

    private fun generateVideoRangeList(videosUri: List<Uri>): VideoRangeList {
        val videoRecords = videosUri.map { fileUri ->
            val videoDuration = DurationExtractor().extractDurationMilliSec(this, fileUri)
            val videoSpeed = 1f
            VideoRecordRange(
                sourceUri = fileUri,
                durationMs = videoDuration,
                speed = videoSpeed
            )
        }
        return VideoRangeList(videoRecords)
    }

    private fun generateEffects(): Effects {
        val effectText = createTextVisualEffect()
        val effectGif = createGifVisualEffect()

        val visualStack = Stack<VisualTimedEffect>().apply {
            add(VisualTimedEffect.getFullRange(effectText))
            add(VisualTimedEffect.getFullRange(effectGif))
        }

        val speedStack = Stack<SpeedTimedEffect>()

        return Effects(
            visualStack = visualStack,
            speedStack = speedStack
        )
    }

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

    private fun pickPredefinedVideos() {
        getPredefinedVideos.launch("video/*")
    }

    private fun progressVisible(isVisible: Boolean) {
        exportProgressView.isVisible = isVisible
        exportBtn.isVisible = !isVisible
    }
}