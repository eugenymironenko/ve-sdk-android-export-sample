//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[EmptyExportSessionHelper](index.md)

# EmptyExportSessionHelper

[androidJvm]\
class [EmptyExportSessionHelper](index.md) : [ExportSessionHelper](../-export-session-helper/index.md)

Default [ExportSessionHelper](../-export-session-helper/index.md) implementation. It does not do anything. Use it if you need only export functionality.

## Constructors

| | |
|---|---|
| [EmptyExportSessionHelper](-empty-export-session-helper.md) | [androidJvm]<br>fun [EmptyExportSessionHelper](-empty-export-session-helper.md)() |

## Functions

| Name | Summary |
|---|---|
| [cleanSessionData](clean-session-data.md) | [androidJvm]<br>open override fun [cleanSessionData](clean-session-data.md)()<br>Removes session data. This function is invoked to clean session if ForegroundExportFlowManager.shouldClearSessionOnFinish or BackgroundExportFlowManager.shouldClearSessionOnFinish are true. |
