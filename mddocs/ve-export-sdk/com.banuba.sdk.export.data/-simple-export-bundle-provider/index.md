//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[SimpleExportBundleProvider](index.md)

# SimpleExportBundleProvider

[androidJvm]\
class [SimpleExportBundleProvider](index.md) : [ExportBundleProvider](../-export-bundle-provider/index.md)

Default [ExportBundleProvider](../-export-bundle-provider/index.md) implementation which only provides a Parcelable object passed into VideoCreationActivity launching intent

## Constructors

| | |
|---|---|
| [SimpleExportBundleProvider](-simple-export-bundle-provider.md) | [androidJvm]<br>fun [SimpleExportBundleProvider](-simple-export-bundle-provider.md)() |

## Functions

| Name | Summary |
|---|---|
| [createBundleAsync](create-bundle-async.md) | [androidJvm]<br>open override fun [createBundleAsync](create-bundle-async.md)(inputData: [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)?, videosInfo: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;VideoInfo&gt;): Deferred&lt;[Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)&gt;<br>Function to create Bundle object within coroutine scope |
