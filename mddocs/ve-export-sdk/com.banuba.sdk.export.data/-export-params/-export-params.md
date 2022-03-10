//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportParams](index.md)/[ExportParams](-export-params.md)

# ExportParams

[androidJvm]\
fun [ExportParams](-export-params.md)(resolution: VideoResolution, aspectRatio: AspectRatio, effects: Effects, videoRangeList: VideoRangeList, debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html), fileExt: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = ".mp4", fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), volumeVideo: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, extraAudioFile: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewParams: GifMaker.Params?, size: [Size](https://developer.android.com/reference/kotlin/android/util/Size.html))

## Parameters

androidJvm

| | |
|---|---|
| resolution | video resolution |
| aspectRatio | video aspect ratio |
| effects | visual and time effects applied to the exported video |
| videoRangeList | video clips to be used in exported video |
| debugEnabled | does debugging and logging enabled during export |
| destDir | directory where exported video will be saved |
| fileExt | exported video extension |
| fileName | exported video name |
| volumeVideo | video volume |
| musicEffects | music effects applied to exported video |
| extraAudioFile | Uri for the sound track, exported as a separate file |
| interactivePreviewParams | configures image preview parameters |
| size | exported video size |
