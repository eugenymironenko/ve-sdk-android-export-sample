[![](https://www.banuba.com/hubfs/Banuba_November2018/Images/Banuba%20SDK.png)](https://www.banuba.com/video-editor-sdk)

# Android Banuba AI Video Editor Export API Integration Sample

This repository contains a sample of using AI Video Editor Export API in your mobile app.

Export API can apply configurable effects to video and export that video with specified parameters. Export API has no UI, hence cannot display applied effects.

It contains the must-have video editing features such as adding video effects, gif/text, watermark, speed effects, color effects, AR effects to the exported video with a predefined position, duration and period. It can also edit the aspect ratio. Supports export in foreground or background mode.

- [Requirements](#Requirements)
- [Dependencies](#Dependencies)
- [Supported media formats](#Supported-media-formats)
- [Export video quality params](#Export-video-quality-params)
- [Token](#Token)
- [Getting Started](#Getting-Started)
    + [Add dependencies](#Add-dependencies)
    + [Configure DI](#Configure-DI)
    + [Configure export flow](#Configure-export-flow)
    + [Configure ExportFlowManager](#Configure-ExportFlowManager)
    + [Configure watermark](#Configure-watermark)
    + [Configure overlay effects](#Configure-overlay-effects)

## Requirements
This is what you need to run the Export API
- Java 1.8+
- Kotlin 1.4+
- Android Studio 4+
- Android OS 6.0 or higher
- OpenGL ES 3.0  

## Dependencies
- [Koin](https://insert-koin.io/)
- [ExoPlayer](https://github.com/google/ExoPlayer)
- [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [ffmpeg](https://github.com/FFmpeg/FFmpeg/tree/n3.4.1)
- [AndroidX](https://developer.android.com/jetpack/androidx) libraries

[Please see all used dependencies](mddocs/all_dependencies.md)

## Supported media formats
| Audio      | Video      |
| ---------- | ---------  | 
|mp3, aac, wav, m4a, flac, aiff |mp4, mov, m4v|

## Export video quality params
The quality and quantity of exported videos can be configured using `ExportParamsProvider` interface. Just put a required video quality into `ExportManager.Params.Builder` constructor. Check out an [**example**](https://vebanuba.notion.site/Configure-export-params-93e66c89d491449ea06cf6f24b739697), where multiple video files are exported: the first and the second with the most suitable quality params (defined by `sizeProvider.provideOptimalExportVideoSize()` method) and the third with 360p quality (defined by using an Export API constant `VideoResolution.VGA360`).
This sample has a custom implementation [ExportParamsProvider](https://github.com/Banuba/ve-sdk-android-export-sample/blob/ae48357eace151e99da3d5ee9be125858663311f/app/src/main/java/com/banuba/example/exportapp/CustomExportParamsProvider.kt).

See the **default bitrate (kb/s)** for exported video (without audio) in the table below:
| 360p(360 x 640) | 480p(480 x 854) | 540p(540 x 960) | HD(720 x 1280) | FHD(1080 x 1920) | 
| --------------- | --------------- | --------------- |--------------- | ---------------- |
|             1200|             2000|            2000 |            4000|              6400|

## Token
We offer а free 14-days trial for you could thoroughly test and assess Export API functionality in your app. To get access to your trial, please, get in touch with us by [filling a form](https://www.banuba.com/video-editor-sdk) on our website. Our sales managers will send you the trial token.

Banuba token should be put [here](https://github.com/Banuba/ve-sdk-android-export-sample/blob/ae48357eace151e99da3d5ee9be125858663311f/app/src/main/res/values/strings.xml#L6).

## Getting Started
### Add dependencies
Please, specify a list of dependencies as in [app/build.gradle](app/build.gradle) file to integrate export functionality of Export API.

``` groovy
def banubaSdkVersion = '1.22.0'
implementation "com.banuba.sdk:banuba-token-storage-sdk:${banubaSdkVersion}"
implementation "com.banuba.sdk:core-sdk:${banubaSdkVersion}"
implementation "com.banuba.sdk:ve-sdk:${banubaSdkVersion}"
implementation "com.banuba.sdk:ve-export-sdk:${banubaSdkVersion}"
```

### Configure DI
You can override the behavior of the export in your app with DI libraries and tools (we use [Koin](https://insert-koin.io/), for example).  
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
You can to override properties to customize the export for your application. Please, take a look at the [full example](app/src/main/java/com/banuba/example/exportapp/ExportSampleKoinModule.kt).

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

### Configure export flow
The Export API exports recordings as .mp4 files. There are many ways you can customize this flow to better integrate it into your app.

To change export output, start with the ```ExportParamsProvider``` interface. It contains one method - ```provideExportParams()``` that returns ```List<ExportManager.Params>```. Each item on this list relates to one of the videos in the output and their configuration.

By default, exported videos are placed in the "export" directory of external storage. To change the target folder, you should provide a custom Uri instance named **exportDir** through DI.

Should you choose to export files in the background, you’d do well to change ```ExportNotificationManager```. It lets you change the notifications for any export scenario (started, finished successfully, and failed).

### Configure ExportFlowManager
Export can work in foreground or background mode. By default export works in foreground mode. But if you need to run the export in the background, you should override `ExportFlowManager` in your own Koin module:
``` kotlin
class ExportSampleKoinModule() {
    val module = module {
        ...
         single(override = true) {
            BackgroundExportFlowManager(
                exportDataProvider = get(),
                sessionParamsProvider = get(),
                exportSessionHelper = get(),
                exportNotificationManager = get(),
                exportDir = get(named("exportDir")),
                publishManager = get(),
                errorParser = get()
            )
        }
        ...
    }
}
```  

If you need both export modes, see the [sample implementation](app/src/main/java/com/banuba/example/exportapp/ExportSampleKoinModule.kt#L19)

ExportFlowManager contains methods for starting(`fun startExport`) and stopping(`fun stopExport`) export, variables for receiving export result(`val resultData`) and export operation mode(`val provideExportInBackground`). 

``` kotlin
interface ExportFlowManager {
    val resultData: LiveData<ExportResult>
    val provideExportInBackground: Boolean

    fun startExport(exportTaskParams: ExportTaskParams)
    fun stopExport()
    fun setInactive()
}
```

To start the export, you need to pass object of `ExportTaskParams` class as an argument to `startExport` method
``` kotlin
/**
* @param videoRanges list of video files to export
* @param effects set of effects that need to be applied to the video
* @param exportMusicParams list of music files to be added to the video
* @param coverFrameSize video cover size
* @param aspect ratio of the video's width to its height.
**/
ExportTaskParams(
    val videoRanges: VideoRangeList,
    val effects: Effects,
    val exportMusicParams: ExportMusicParams,
    val coverFrameSize: Size,
    val aspect: AspectRatio
)
```
Example of creating a `ExportTaskParams` object can be found [here](app/src/main/java/com/banuba/example/exportapp/MainActivity.kt#L68).

The export work state can take the following states:
``` kotlin
sealed class ExportResult {
    object Inactive : ExportResult()

    object Stopped : ExportResult()

    data class Progress(val preview: Uri) : ExportResult()

    @Parcelize
    data class Success(
        val message: String,
        val videoList: List<ExportedVideo>,
        val preview: Uri,
    ) : ExportResult(), Parcelable

    @Parcelize
    data class Error(val type: ExportError) : ExportResult(), Parcelable
}
```
Example of processing the export result can be found [here](app/src/main/java/com/banuba/example/exportapp/MainActivity.kt#L83).

### Configure watermark
To use a watermark, add the `WatermarkProvider` interface to your app. The image goes into the getWatermarkBitmap method. Once you’re done, rearrange the dependency watermarkProvider in [DI](app/src/main/java/com/banuba/example/exportapp/ExportSampleKoinModule.kt#L52).

### Configure overlay effects
You can add an effect objects such as gif and text to exporting video. 

To create this effects you need to use `TextObjectDrawable` and `GifObjectDrawable` classes.

To create more advanced effects (i.e. fx or time effects) you should use an additional dependency:

``` groovy
implementation "com.banuba.sdk:ve-effects-sdk:${banubaSdkVersion}"
```

Note that you can use **fx** and **time** effects only available to you according to the pricing plan. Trying to use prohibited effects will lead to an exception.

Please, checkout [example](app/src/main/java/com/banuba/example/exportapp/MainActivity.kt#L173) of creating effects.

## API Reference

List of Video Editor APIs utilized in export sample.

### Export API

```ve-export-sdk``` module contains interfaces and classes for handling and configuring export process.

[API Reference](mddocs/index.md)