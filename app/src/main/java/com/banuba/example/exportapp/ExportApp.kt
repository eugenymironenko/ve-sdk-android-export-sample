package com.banuba.example.exportapp

import android.app.Application
import com.banuba.sdk.export.di.VeExportKoinModule
import com.banuba.sdk.token.storage.di.TokenStorageKoinModule
import com.banuba.sdk.ve.di.VeSdkKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExportApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExportApp)
            modules(
                VeSdkKoinModule().module,
                VeExportKoinModule().module,
                TokenStorageKoinModule().module,
                ExportSampleKoinModule().module
            )
        }
    }
}