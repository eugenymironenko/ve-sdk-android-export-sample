package com.banuba.example.exportapp

import android.net.Uri
import androidx.core.net.toFile
import com.banuba.sdk.core.VideoResolution
import com.banuba.sdk.core.media.MediaFileNameHelper
import com.banuba.sdk.export.data.EnableExportAudioProvider
import com.banuba.sdk.export.data.ExportParamsProvider
import com.banuba.sdk.ve.domain.VideoRangeList
import com.banuba.sdk.ve.effects.Effects
import com.banuba.sdk.ve.effects.WatermarkAlignment
import com.banuba.sdk.ve.effects.WatermarkBuilder
import com.banuba.sdk.ve.effects.music.MusicEffect
import com.banuba.sdk.ve.ext.withWatermark
import com.banuba.sdk.ve.processing.ExportManager

class CustomExportParamsProvider(
    private val exportDir: Uri,
    private val mediaFileNameHelper: MediaFileNameHelper,
    private val watermarkBuilder: WatermarkBuilder,
    private val exportAudioProvider: EnableExportAudioProvider
) : ExportParamsProvider {

    override fun provideExportParams(
        effects: Effects,
        videoRangeList: VideoRangeList,
        musicEffects: List<MusicEffect>,
        videoVolume: Float
    ): List<ExportManager.Params> {
        val exportSessionDir = exportDir.toFile().apply {
            deleteRecursively()
            mkdirs()
        }

        val extraSoundtrackUri = if (exportAudioProvider.isEnable) {
            Uri.parse(exportSessionDir.toString()).buildUpon()
                .appendPath(mediaFileNameHelper.generateExportSoundtrackFileName())
                .build()
        } else Uri.EMPTY

        val paramsHdWithWatermark =
            ExportManager.Params.Builder(VideoResolution.Exact.HD)
                .effects(effects.withWatermark(watermarkBuilder, WatermarkAlignment.BOTTOM_RIGHT))
                .fileName("export_default")
                .debugEnabled(true)
                .videoRangeList(videoRangeList)
                .destDir(exportSessionDir)
                .musicEffects(musicEffects)
                .volumeVideo(videoVolume)
                .extraAudioFile(extraSoundtrackUri)
                .build()

        return listOf(paramsHdWithWatermark)
    }
}
