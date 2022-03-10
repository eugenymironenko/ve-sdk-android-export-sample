//[ve-export-sdk](../../../../index.md)/[com.banuba.sdk.export.data](../../index.md)/[ExportResult](../index.md)/[Progress](index.md)

# Progress

[androidJvm]\
data class [Progress](index.md)(preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)) : [ExportResult](../index.md)

Means that export is in progress. During the normal export flow there are two possible [Progress](index.md) states: without preview image ([preview](preview.md) == Uri.EMPTY) - when the export just was started, with preview image - when the preview image is ready and export continues to be processed.

## Parameters

androidJvm

| | |
|---|---|
| preview | Uri to the preview image |

## Constructors

| | |
|---|---|
| [Progress](-progress.md) | [androidJvm]<br>fun [Progress](-progress.md)(preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)) |

## Properties

| Name | Summary |
|---|---|
| [preview](preview.md) | [androidJvm]<br>val [preview](preview.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
