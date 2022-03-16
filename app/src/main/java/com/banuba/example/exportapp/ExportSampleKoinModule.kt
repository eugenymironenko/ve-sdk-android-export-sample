package com.banuba.example.exportapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.banuba.example.exportapp.utils.StubImageLoader
import com.banuba.sdk.core.domain.ImageLoader
import com.banuba.sdk.core.media.DurationExtractor
import com.banuba.sdk.export.data.BackgroundExportFlowManager
import com.banuba.sdk.export.data.ExportFlowManager
import com.banuba.sdk.export.data.ExportParamsProvider
import com.banuba.sdk.export.data.ForegroundExportFlowManager
import com.banuba.sdk.ve.R
import com.banuba.sdk.ve.effects.WatermarkProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

class ExportSampleKoinModule {

    val module = module {

        single<ExportFlowManager>(named("foregroundExportFlowManager"), override = true) {
            ForegroundExportFlowManager(
                exportDataProvider = get(),
                sessionParamsProvider = get(),
                exportSessionHelper = get(),
                exportDir = get(named("exportDir")),
                publishManager = get(),
                errorParser = get(),
                mediaFileNameHelper = get(),
                exportBundleProvider = get()
            )
        }

        single<ExportFlowManager>(named("backgroundExportFlowManager"), override = true) {
            BackgroundExportFlowManager(
                exportDataProvider = get(),
                sessionParamsProvider = get(),
                exportSessionHelper = get(),
                exportNotificationManager = get(),
                exportDir = get(named("exportDir")),
                publishManager = get(),
                errorParser = get(),
                exportBundleProvider = get()
            )
        }

        factory<ExportParamsProvider>(override = true) {
            CustomExportParamsProvider(
                exportDir = get(named("exportDir")),
                mediaFileNameHelper = get(),
                watermarkBuilder = get(),
                exportAudioProvider = get()
            )
        }

        single<WatermarkProvider>(override = true) {
            object : WatermarkProvider {
                override fun getWatermarkBitmap(): Bitmap? = BitmapFactory.decodeResource(
                    androidContext().resources,
                    R.drawable.df_fsfw
                )
            }
        }

        single<ImageLoader>(override = true) {
            StubImageLoader()
        }

        single(named("videoDurationExtractor")) {
            DurationExtractor(video = true)
        }
    }
}