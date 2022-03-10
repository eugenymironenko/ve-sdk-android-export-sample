//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportNotificationManager](index.md)

# ExportNotificationManager

[androidJvm]\
interface [ExportNotificationManager](index.md)

Interface for managing status bar notifications during export. It is used only in case of [BackgroundExportFlowManager](../-background-export-flow-manager/index.md).

## Functions

| Name | Summary |
|---|---|
| [showExportStartedNotification](show-export-started-notification.md) | [androidJvm]<br>abstract fun [showExportStartedNotification](show-export-started-notification.md)()<br>Shows a notification of started export |
| [showFailedExportExportNotification](show-failed-export-export-notification.md) | [androidJvm]<br>abstract fun [showFailedExportExportNotification](show-failed-export-export-notification.md)()<br>Shows a notification of failed export |
| [showSuccessfulExportNotification](show-successful-export-notification.md) | [androidJvm]<br>abstract fun [showSuccessfulExportNotification](show-successful-export-notification.md)(result: [ExportResult.Success](../-export-result/-success/index.md))<br>Shows a notification of successfully finished export. |

## Inheritors

| Name |
|---|
| [DefaultExportNotificationManger](../-default-export-notification-manger/index.md) |
