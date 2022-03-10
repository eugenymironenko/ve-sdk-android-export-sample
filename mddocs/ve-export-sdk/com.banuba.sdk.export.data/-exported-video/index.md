//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportedVideo](index.md)

# ExportedVideo

[androidJvm]\
data class [ExportedVideo](index.md)(sourceUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), soundTrackUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), durationMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

Data class representing the video after successful export.

## Parameters

androidJvm

| | |
|---|---|
| sourceUri | Uri of the video |
| width | width of the video |
| height | height of the video |
| soundTrackUri | Uri of the sound track over the video |
| interactivePreviewUri | Uri of the preview image |
| durationMs | duration of the video in milliseconds |

## Constructors

| | |
|---|---|
| [ExportedVideo](-exported-video.md) | [androidJvm]<br>fun [ExportedVideo](-exported-video.md)(sourceUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), soundTrackUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), interactivePreviewUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), durationMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [describeContents](index.md#-1578325224%2FFunctions%2F545878494) | [androidJvm]<br>abstract fun [describeContents](index.md#-1578325224%2FFunctions%2F545878494)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [writeToParcel](index.md#-1754457655%2FFunctions%2F545878494) | [androidJvm]<br>abstract fun [writeToParcel](index.md#-1754457655%2FFunctions%2F545878494)(p0: [Parcel](https://developer.android.com/reference/kotlin/android/os/Parcel.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [durationMs](duration-ms.md) | [androidJvm]<br>val [durationMs](duration-ms.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [height](height.md) | [androidJvm]<br>val [height](height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [interactivePreviewUri](interactive-preview-uri.md) | [androidJvm]<br>val [interactivePreviewUri](interactive-preview-uri.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
| [soundTrackUri](sound-track-uri.md) | [androidJvm]<br>val [soundTrackUri](sound-track-uri.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
| [sourceUri](source-uri.md) | [androidJvm]<br>var [sourceUri](source-uri.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
| [width](width.md) | [androidJvm]<br>val [width](width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
