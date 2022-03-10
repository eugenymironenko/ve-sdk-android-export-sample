//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportError](index.md)

# ExportError

[androidJvm]\
enum [ExportError](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[ExportError](index.md)&gt; 

Types of export errors which are possible during export

## Parameters

androidJvm

| | |
|---|---|
| messageResId | string resource for user friendly message, which is used on UI |

## Entries

| | |
|---|---|
| [FFMPEG_ERROR](-f-f-m-p-e-g_-e-r-r-o-r/index.md) | [androidJvm]<br>[FFMPEG_ERROR](-f-f-m-p-e-g_-e-r-r-o-r/index.md)(R.string.internal_error)<br>Error type related to FFMPEG processing |
| [UNKNOWN](-u-n-k-n-o-w-n/index.md) | [androidJvm]<br>[UNKNOWN](-u-n-k-n-o-w-n/index.md)(R.string.export_unknown_error)<br>Any errors with unknown reason |
| [CODEC_ERROR](-c-o-d-e-c_-e-r-r-o-r/index.md) | [androidJvm]<br>[CODEC_ERROR](-c-o-d-e-c_-e-r-r-o-r/index.md)(R.string.export_codec_error)<br>Error type related to MediaCodec errors |
| [EXPORT_RESULT_ERROR](-e-x-p-o-r-t_-r-e-s-u-l-t_-e-r-r-o-r/index.md) | [androidJvm]<br>[EXPORT_RESULT_ERROR](-e-x-p-o-r-t_-r-e-s-u-l-t_-e-r-r-o-r/index.md)(R.string.export_result_error)<br>Error type related to mapping exported data into [ExportResult](../-export-result/index.md) object. |
| [PREVIEW_ERROR](-p-r-e-v-i-e-w_-e-r-r-o-r/index.md) | [androidJvm]<br>[PREVIEW_ERROR](-p-r-e-v-i-e-w_-e-r-r-o-r/index.md)(R.string.preview_error)<br>Error type related to video's preview image |

## Properties

| Name | Summary |
|---|---|
| [messageResId](message-res-id.md) | [androidJvm]<br>val [messageResId](message-res-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [name](-p-r-e-v-i-e-w_-e-r-r-o-r/index.md#-372974862%2FProperties%2F545878494) | [androidJvm]<br>val [name](-p-r-e-v-i-e-w_-e-r-r-o-r/index.md#-372974862%2FProperties%2F545878494): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](-p-r-e-v-i-e-w_-e-r-r-o-r/index.md#-739389684%2FProperties%2F545878494) | [androidJvm]<br>val [ordinal](-p-r-e-v-i-e-w_-e-r-r-o-r/index.md#-739389684%2FProperties%2F545878494): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
