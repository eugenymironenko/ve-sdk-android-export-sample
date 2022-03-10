//[ve-export-sdk](../../../../index.md)/[com.banuba.sdk.export.data](../../index.md)/[ExportResult](../index.md)/[Success](index.md)/[Success](-success.md)

# Success

[androidJvm]\
fun [Success](-success.md)(videoList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportedVideo](../../-exported-video/index.md)&gt;, preview: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), metaUri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), additionalExportData: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))

## Parameters

androidJvm

| | |
|---|---|
| videoList | list of [ExportedVideo](../../-exported-video/index.md) objects. |
| preview | Uri of the preview image |
| metaUri | Uri of the json file containing session data |
| additionalExportData | Bundle object with additional information. It contains:<br>1.     data provided by the [ExportBundleProvider](../../-export-bundle-provider/index.md) (extracted by ExportBundleProvider.Keys.EXTRA_EXPORT_OUTPUT_INFO key); 2.     data passed into VideoCreationActivity as Parcelable into additionalExportData field (extracted by ExportBundleProvider.Keys.EXTRA_EXPORT_INPUT_INFO key). By utilizing this property it is possible to pass any Parcelable object through video editor flow and obtain it right after successful export. |
