//[ve-export-sdk](../../../../index.md)/[com.banuba.sdk.export.data](../../index.md)/[ExportResult](../index.md)/[Success](index.md)

# Success

[androidJvm]\
data class [Success](index.md)(videoList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportedVideo](../../-exported-video/index.md)&gt;, preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), metaUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), additionalExportData: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)) : [ExportResult](../index.md), [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

Means that export successfully finished.

## Parameters

androidJvm

| | |
|---|---|
| videoList | list of [ExportedVideo](../../-exported-video/index.md) objects. |
| preview | Uri of the preview image |
| metaUri | Uri of the json file containing session data |
| additionalExportData | Bundle object with additional information. It contains:<br>1.     data provided by the [ExportBundleProvider](../../-export-bundle-provider/index.md) (extracted by ExportBundleProvider.Keys.EXTRA_EXPORT_OUTPUT_INFO key); 2.     data passed into VideoCreationActivity as Parcelable into additionalExportData field (extracted by ExportBundleProvider.Keys.EXTRA_EXPORT_INPUT_INFO key). By utilizing this property it is possible to pass any Parcelable object through video editor flow and obtain it right after successful export. |

## Constructors

| | |
|---|---|
| [Success](-success.md) | [androidJvm]<br>fun [Success](-success.md)(videoList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportedVideo](../../-exported-video/index.md)&gt;, preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), metaUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), additionalExportData: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)) |

## Functions

| Name | Summary |
|---|---|
| [describeContents](../../-exported-video/index.md#-1578325224%2FFunctions%2F545878494) | [androidJvm]<br>abstract fun [describeContents](../../-exported-video/index.md#-1578325224%2FFunctions%2F545878494)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [writeToParcel](../../-exported-video/index.md#-1754457655%2FFunctions%2F545878494) | [androidJvm]<br>abstract fun [writeToParcel](../../-exported-video/index.md#-1754457655%2FFunctions%2F545878494)(p0: [Parcel](https://developer.android.com/reference/kotlin/android/os/Parcel.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [additionalExportData](additional-export-data.md) | [androidJvm]<br>val [additionalExportData](additional-export-data.md): [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html) |
| [metaUri](meta-uri.md) | [androidJvm]<br>val [metaUri](meta-uri.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
| [preview](preview.md) | [androidJvm]<br>val [preview](preview.md): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html) |
| [videoList](video-list.md) | [androidJvm]<br>val [videoList](video-list.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportedVideo](../../-exported-video/index.md)&gt; |
