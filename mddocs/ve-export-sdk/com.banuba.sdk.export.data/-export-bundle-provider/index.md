//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportBundleProvider](index.md)

# ExportBundleProvider

[androidJvm]\
interface [ExportBundleProvider](index.md)

Interface to provide [ExportResult.Success.additionalExportData](../-export-result/-success/additional-export-data.md)

## Types

| Name | Summary |
|---|---|
| [Keys](-keys/index.md) | [androidJvm]<br>object [Keys](-keys/index.md)<br>Keys to map data |

## Functions

| Name | Summary |
|---|---|
| [createBundleAsync](create-bundle-async.md) | [androidJvm]<br>abstract fun [createBundleAsync](create-bundle-async.md)(inputData: [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)?, videosInfo: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;VideoInfo&gt;): Deferred&lt;[Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)&gt;<br>Function to create Bundle object within coroutine scope |

## Inheritors

| Name |
|---|
| [SimpleExportBundleProvider](../-simple-export-bundle-provider/index.md) |
