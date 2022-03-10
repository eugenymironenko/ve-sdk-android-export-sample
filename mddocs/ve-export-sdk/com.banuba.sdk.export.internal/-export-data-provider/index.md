//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.internal](../index.md)/[ExportDataProvider](index.md)

# ExportDataProvider

[androidJvm]\
interface [ExportDataProvider](index.md)

## Functions

| Name | Summary |
|---|---|
| [requestExportAsync](request-export-async.md) | [androidJvm]<br>abstract fun [requestExportAsync](request-export-async.md)(params: [ExportTaskParams](../../com.banuba.sdk.export.data/-export-task-params/index.md)): Deferred&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportResultData](../../com.banuba.sdk.export.data/-export-result-data/index.md)&gt;&gt; |
| [requestPreviewAsync](request-preview-async.md) | [androidJvm]<br>abstract fun [requestPreviewAsync](request-preview-async.md)(params: [ExportTaskParams](../../com.banuba.sdk.export.data/-export-task-params/index.md)): Deferred&lt;[Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[ExportedPreview](../../com.banuba.sdk.export.data/-exported-preview/index.md)&gt;&gt; |
| [requestStopExport](request-stop-export.md) | [androidJvm]<br>abstract fun [requestStopExport](request-stop-export.md)() |
