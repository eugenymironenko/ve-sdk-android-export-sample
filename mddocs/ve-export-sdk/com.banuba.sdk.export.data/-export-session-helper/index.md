//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportSessionHelper](index.md)

# ExportSessionHelper

[androidJvm]\
interface [ExportSessionHelper](index.md)

Interface which manages session data during export.

## Functions

| Name | Summary |
|---|---|
| [cleanSessionData](clean-session-data.md) | [androidJvm]<br>abstract fun [cleanSessionData](clean-session-data.md)()<br>Removes session data. This function is invoked to clean session if ForegroundExportFlowManager.shouldClearSessionOnFinish or BackgroundExportFlowManager.shouldClearSessionOnFinish are true. |

## Inheritors

| Name |
|---|
| [EmptyExportSessionHelper](../-empty-export-session-helper/index.md) |
