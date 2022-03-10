//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[BackgroundExportFlowManager](index.md)

# BackgroundExportFlowManager

[androidJvm]\
class [BackgroundExportFlowManager](index.md)(exportDataProvider: [ExportDataProvider](../../com.banuba.sdk.export.internal/-export-data-provider/index.md), sessionParamsProvider: SessionParamsProvider, exportSessionHelper: [ExportSessionHelper](../-export-session-helper/index.md), exportNotificationManager: [ExportNotificationManager](../-export-notification-manager/index.md), exportDir: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), shouldClearSessionOnFinish: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), publishManager: [PublishManager](../-publish-manager/index.md), errorParser: [ExportErrorParser](../-export-error-parser/index.md), exportBundleProvider: [ExportBundleProvider](../-export-bundle-provider/index.md)) : [ExportFlowManager](../-export-flow-manager/index.md)

Default [ExportFlowManager](../-export-flow-manager/index.md) implementation which provides export in the background

## Constructors

| | |
|---|---|
| [BackgroundExportFlowManager](-background-export-flow-manager.md) | [androidJvm]<br>fun [BackgroundExportFlowManager](-background-export-flow-manager.md)(exportDataProvider: [ExportDataProvider](../../com.banuba.sdk.export.internal/-export-data-provider/index.md), sessionParamsProvider: SessionParamsProvider, exportSessionHelper: [ExportSessionHelper](../-export-session-helper/index.md) = EmptyExportSessionHelper(), exportNotificationManager: [ExportNotificationManager](../-export-notification-manager/index.md), exportDir: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), shouldClearSessionOnFinish: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, publishManager: [PublishManager](../-publish-manager/index.md), errorParser: [ExportErrorParser](../-export-error-parser/index.md), exportBundleProvider: [ExportBundleProvider](../-export-bundle-provider/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [setInactive](set-inactive.md) | [androidJvm]<br>open override fun [setInactive](set-inactive.md)()<br>Sets export state to [ExportResult.Inactive](../-export-result/-inactive/index.md). This state is an initial state therefore this method is an equivalent of refreshing [resultData](result-data.md) object |
| [startExport](start-export.md) | [androidJvm]<br>open override fun [startExport](start-export.md)(exportTaskParams: [ExportTaskParams](../-export-task-params/index.md))<br>Starts export |
| [stopExport](stop-export.md) | [androidJvm]<br>open override fun [stopExport](stop-export.md)()<br>Stops export |

## Properties

| Name | Summary |
|---|---|
| [provideExportInBackground](provide-export-in-background.md) | [androidJvm]<br>open override val [provideExportInBackground](provide-export-in-background.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Shows if the current implementation provides export in the background |
| [resultData](result-data.md) | [androidJvm]<br>open override val [resultData](result-data.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[ExportResult](../-export-result/index.md)&gt;<br>LiveData object that holds [ExportResult](../-export-result/index.md). Observe it to track export process. |
