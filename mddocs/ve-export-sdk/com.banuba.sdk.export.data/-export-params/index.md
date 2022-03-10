//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportParams](index.md)

# ExportParams

[androidJvm]\
data class [ExportParams](index.md)(resolution: VideoResolution, aspectRatio: AspectRatio, effects: Effects, videoRangeList: VideoRangeList, debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html), fileExt: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), volumeVideo: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, extraAudioFile: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewParams: GifMaker.Params?, size: [Size](https://developer.android.com/reference/kotlin/android/util/Size.html))

Data class to configure export request.

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

## Constructors

| | |
|---|---|
| [ExportParams](-export-params.md) | [androidJvm]<br>fun [ExportParams](-export-params.md)(resolution: VideoResolution, aspectRatio: AspectRatio, effects: Effects, videoRangeList: VideoRangeList, debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html), fileExt: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = ".mp4", fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), volumeVideo: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, extraAudioFile: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewParams: GifMaker.Params?, size: [Size](https://developer.android.com/reference/kotlin/android/util/Size.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [androidJvm]<br>data class [Builder](-builder/index.md)(resolution: VideoResolution, debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), effects: Effects?, videoRangeList: VideoRangeList?, fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html)?, volumeVideo: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, extraAudioFile: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewParams: GifMaker.Params?)<br>Helper class for easy creation of [ExportParams](index.md) object |

## Properties

| Name | Summary |
|---|---|
| [aspectRatio](aspect-ratio.md) | [androidJvm]<br>val [aspectRatio](aspect-ratio.md): AspectRatio |
| [debugEnabled](debug-enabled.md) | [androidJvm]<br>val [debugEnabled](debug-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [destDir](dest-dir.md) | [androidJvm]<br>val [destDir](dest-dir.md): [File](https://developer.android.com/reference/kotlin/java/io/File.html) |
| [effects](effects.md) | [androidJvm]<br>val [effects](effects.md): Effects |
| [extraAudioFile](extra-audio-file.md) | [androidJvm]<br>val [extraAudioFile](extra-audio-file.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
| [fileExt](file-ext.md) | [androidJvm]<br>val [fileExt](file-ext.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [fileName](file-name.md) | [androidJvm]<br>val [fileName](file-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [interactivePreviewParams](interactive-preview-params.md) | [androidJvm]<br>val [interactivePreviewParams](interactive-preview-params.md): GifMaker.Params? |
| [musicEffects](music-effects.md) | [androidJvm]<br>val [musicEffects](music-effects.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt; |
| [resolution](resolution.md) | [androidJvm]<br>val [resolution](resolution.md): VideoResolution |
| [size](size.md) | [androidJvm]<br>val [size](size.md): [Size](https://developer.android.com/reference/kotlin/android/util/Size.html) |
| [videoRangeList](video-range-list.md) | [androidJvm]<br>val [videoRangeList](video-range-list.md): VideoRangeList |
| [volumeVideo](volume-video.md) | [androidJvm]<br>val [volumeVideo](volume-video.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
