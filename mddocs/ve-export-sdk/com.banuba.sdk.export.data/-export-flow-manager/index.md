//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportFlowManager](index.md)

# ExportFlowManager

[androidJvm]\
interface [ExportFlowManager](index.md)

Main interface that is used to manage export flow. There are two implementations for different cases: [BackgroundExportFlowManager](../-background-export-flow-manager/index.md) for export which is processed in the background; [ForegroundExportFlowManager](../-foreground-export-flow-manager/index.md) for export which is processed in the foreground.

## Functions

| Name | Summary |
|---|---|
| [setInactive](set-inactive.md) | [androidJvm]<br>abstract fun [setInactive](set-inactive.md)()<br>Sets export state to [ExportResult.Inactive](../-export-result/-inactive/index.md). This state is an initial state therefore this method is an equivalent of refreshing [resultData](result-data.md) object |
| [startExport](start-export.md) | [androidJvm]<br>abstract fun [startExport](start-export.md)(exportTaskParams: [ExportTaskParams](../-export-task-params/index.md))<br>Starts export |
| [stopExport](stop-export.md) | [androidJvm]<br>abstract fun [stopExport](stop-export.md)()<br>Stops export |

## Properties

| Name | Summary |
|---|---|
| [provideExportInBackground](provide-export-in-background.md) | [androidJvm]<br>abstract val [provideExportInBackground](provide-export-in-background.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Shows if the current implementation provides export in the background |
| [resultData](result-data.md) | [androidJvm]<br>abstract val [resultData](result-data.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[ExportResult](../-export-result/index.md)&gt;<br>LiveData object that holds [ExportResult](../-export-result/index.md). Observe it to track export process. |

## Inheritors

| Name |
|---|
| [BackgroundExportFlowManager](../-background-export-flow-manager/index.md) |
| [ForegroundExportFlowManager](../-foreground-export-flow-manager/index.md) |
