package com.banuba.example.exportapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.banuba.example.exportapp.CustomExportParamsProvider
import com.banuba.sdk.export.data.BackgroundExportFlowManager
import com.banuba.sdk.export.data.ExportParamsProvider
import com.banuba.sdk.ve.R
import com.banuba.sdk.ve.effects.WatermarkProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

class VideoEditorModule() {

    val module = module {

        single(override = true) {
            BackgroundExportFlowManager(
                exportDataProvider = get(),
                sessionParamsProvider = get(),
                exportSessionHelper = get(),
                exportNotificationManager = get(),
                exportDir = get(named("exportDir")),
                shouldClearSessionOnFinish = false,
                publishManager = get(),
                errorParser = get()
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


    }


}