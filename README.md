# Android Banuba Export API Sample

This repository contains sample of using Banuba Export API. The sample demonstrates how to create a video with text and sticker effects.

## Requirements
This is what you need to run the AI Video Editor SDK
- Java 1.8+
- Kotlin 1.4+
- Android Studio 4+
- Android OS 6.0 or higher with Camera 2 API
- OpenGL ES 3.0 (3.1 for Neural networks on GPU)  

## Dependencies
- [Koin](https://insert-koin.io/)
- [ExoPlayer](https://github.com/google/ExoPlayer)
- [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [ffmpeg](https://github.com/FFmpeg/FFmpeg/tree/n3.4.1)
- [AndroidX](https://developer.android.com/jetpack/androidx) libraries

[Please see all used dependencies](mddocs/all_dependencies.md)

## Export video quality params
The quality and quantity of exported videos can be configured using `ExportParamsProvider` interface. Just put a required video quality into `ExportManager.Params.Builder` constructor. Check out an [**example**](https://vebanuba.notion.site/Configure-export-params-93e66c89d491449ea06cf6f24b739697), where multiple video files are exported: the first and the second with the most suitable quality params (defined by `sizeProvider.provideOptimalExportVideoSize()` method) and the third with 360p quality (defined by using an Video Editor SDK constant `VideoResolution.VGA360`).
This sample has a custom implementation [ExportParamsProvider](https://github.com/Banuba/ve-sdk-android-export-sample/blob/ae48357eace151e99da3d5ee9be125858663311f/app/src/main/java/com/banuba/example/exportapp/CustomExportParamsProvider.kt).

See the **default bitrate (kb/s)** for exported video (without audio) in the table below:
| 360p(360 x 640) | 480p(480 x 854) | HD(720 x 1280) | FHD(1080 x 1920) |
| --------------- | --------------- | -------------- | ---------------- |
|             1200|             2000|            4000|              6400|

## Token
We offer а free 14-days trial for you could thoroughly test and assess Video Editor SDK functionality in your app. To get access to your trial, please, get in touch with us by [filling a form](https://www.banuba.com/video-editor-sdk) on our website. Our sales managers will send you the trial token.

Banuba token should be put [here](https://github.com/Banuba/ve-sdk-android-export-sample/blob/ae48357eace151e99da3d5ee9be125858663311f/app/src/main/res/values/strings.xml#L6).

## Getting Started
### Add dependencies
Please, specify a list of dependencies as in [app/build.gradle](app/build.gradle) file to integrate AI Video Editor SDK.

``` xml
def banubaSdkVersion = '1.0.18.1'
implementation "com.banuba.sdk:banuba-token-storage-sdk:${banubaSdkVersion}"
implementation "com.banuba.sdk:core-sdk:${banubaSdkVersion}"
implementation "com.banuba.sdk:ve-sdk:${banubaSdkVersion}"
implementation "com.banuba.sdk:ve-export-sdk:${banubaSdkVersion}"
```

### Configure DI
You can override the behavior of the video editor in your app with DI libraries and tools (we use [Koin](https://insert-koin.io/), for example).  
First, you can create your own KoinModule.
``` kotlin
class ExportSampleKoinModule() {
    val module = module {

        factory<ExportParamsProvider>(override = true) {
            CustomExportParamsProvider(
                exportDir = get(named("exportDir")),
                mediaFileNameHelper = get(),
                watermarkBuilder = get(),
                exportAudioProvider = get()
            )
        }
    }
}
```  
You can to override properties to customize the video editor for your application. Please, take a look at the [full example](app/src/main/java/com/banuba/example/exportapp/ExportSampleKoinModule.kt).

Once you’ve overridden the properties that you need, initialize the Koin module in your [Application.onCreate](app/src/main/java/com/banuba/example/exportapp/ExportApp.kt#L12) method.
``` kotlin
override fun onCreate() {
    super.onCreate()
    startKoin {
        androidContext(this@ExportApp)
        modules(
            VeSdkKoinModule().module,
            VeExportKoinModule().module,
            TokenStorageKoinModule().module,
            ExportSampleKoinModule().module,
        )
    }
}
```