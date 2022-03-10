//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[SimpleExportBundleProvider](index.md)/[createBundleAsync](create-bundle-async.md)

# createBundleAsync

[androidJvm]\
open override fun [createBundleAsync](create-bundle-async.md)(inputData: [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)?, videosInfo: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;VideoInfo&gt;): Deferred&lt;[Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)&gt;

Function to create Bundle object within coroutine scope

## Parameters

androidJvm

| | |
|---|---|
| inputData | Parcelable object passed into video editor on its launch |
| videosInfo | list of VideoInfo objects |
