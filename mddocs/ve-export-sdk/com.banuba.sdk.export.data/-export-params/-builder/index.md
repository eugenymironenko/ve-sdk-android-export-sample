//[ve-export-sdk](../../../../index.md)/[com.banuba.sdk.export.data](../../index.md)/[ExportParams](../index.md)/[Builder](index.md)

# Builder

[androidJvm]\
data class [Builder](index.md)(resolution: VideoResolution, debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), effects: Effects?, videoRangeList: VideoRangeList?, fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html)?, volumeVideo: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, extraAudioFile: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewParams: GifMaker.Params?)

Helper class for easy creation of [ExportParams](../index.md) object

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [androidJvm]<br>fun [Builder](-builder.md)(resolution: VideoResolution, debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, effects: Effects? = null, videoRangeList: VideoRangeList? = null, fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html)? = null, volumeVideo: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = 1.0f, musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt; = emptyList(), extraAudioFile: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) = Uri.EMPTY, interactivePreviewParams: GifMaker.Params? = null) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>fun [build](build.md)(): [ExportParams](../index.md) |
| [debugEnabled](debug-enabled.md) | [androidJvm]<br>fun [debugEnabled](debug-enabled.md)(debugEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [ExportParams.Builder](index.md) |
| [destDir](dest-dir.md) | [androidJvm]<br>fun [destDir](dest-dir.md)(destDir: [File](https://developer.android.com/reference/kotlin/java/io/File.html)): [ExportParams.Builder](index.md) |
| [effects](effects.md) | [androidJvm]<br>fun [effects](effects.md)(effects: Effects): [ExportParams.Builder](index.md) |
| [extraAudioFile](extra-audio-file.md) | [androidJvm]<br>fun [extraAudioFile](extra-audio-file.md)(extraAudioTrack: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)): [ExportParams.Builder](index.md) |
| [fileName](file-name.md) | [androidJvm]<br>fun [fileName](file-name.md)(fileName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ExportParams.Builder](index.md) |
| [interactivePreview](interactive-preview.md) | [androidJvm]<br>fun [interactivePreview](interactive-preview.md)(params: GifMaker.Params): [ExportParams.Builder](index.md) |
| [musicEffects](music-effects.md) | [androidJvm]<br>fun [musicEffects](music-effects.md)(musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;): [ExportParams.Builder](index.md) |
| [videoRangeList](video-range-list.md) | [androidJvm]<br>fun [videoRangeList](video-range-list.md)(videoRangeList: VideoRangeList): [ExportParams.Builder](index.md) |
| [volumeVideo](volume-video.md) | [androidJvm]<br>fun [volumeVideo](volume-video.md)(volumeAudio: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [ExportParams.Builder](index.md) |
