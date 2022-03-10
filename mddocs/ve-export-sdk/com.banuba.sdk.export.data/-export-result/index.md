//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportResult](index.md)

# ExportResult

[androidJvm]\
sealed class [ExportResult](index.md)

The state of export process

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>data class [Error](-error/index.md)(type: [ExportError](../-export-error/index.md)) : [ExportResult](index.md), [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)<br>Means that error was happened during export |
| [Inactive](-inactive/index.md) | [androidJvm]<br>object [Inactive](-inactive/index.md) : [ExportResult](index.md)<br>Means that export was not started yet |
| [Progress](-progress/index.md) | [androidJvm]<br>data class [Progress](-progress/index.md)(preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)) : [ExportResult](index.md)<br>Means that export is in progress. During the normal export flow there are two possible [Progress](-progress/index.md) states: without preview image ([preview](-progress/preview.md) == Uri.EMPTY) - when the export just was started, with preview image - when the preview image is ready and export continues to be processed. |
| [Stopped](-stopped/index.md) | [androidJvm]<br>object [Stopped](-stopped/index.md) : [ExportResult](index.md)<br>Means that export was started and stopped |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(videoList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportedVideo](../-exported-video/index.md)&gt;, preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), metaUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), additionalExportData: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)) : [ExportResult](index.md), [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)<br>Means that export successfully finished. |

## Inheritors

| Name |
|---|
| [Inactive](-inactive/index.md) |
| [Stopped](-stopped/index.md) |
| [Progress](-progress/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md) |
