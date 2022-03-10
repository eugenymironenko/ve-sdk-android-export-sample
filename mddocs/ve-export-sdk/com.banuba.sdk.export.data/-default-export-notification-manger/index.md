//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[DefaultExportNotificationManger](index.md)

# DefaultExportNotificationManger

[androidJvm]\
class [DefaultExportNotificationManger](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), notificationManager: [NotificationManager](https://developer.android.com/reference/kotlin/android/app/NotificationManager.html)) : [ExportNotificationManager](../-export-notification-manager/index.md)

Default [ExportNotificationManager](../-export-notification-manager/index.md) implementation. It creates a separate channel for export notifications and sends notification on started, failed and successfully finished export.

## Constructors

| | |
|---|---|
| [DefaultExportNotificationManger](-default-export-notification-manger.md) | [androidJvm]<br>fun [DefaultExportNotificationManger](-default-export-notification-manger.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), notificationManager: [NotificationManager](https://developer.android.com/reference/kotlin/android/app/NotificationManager.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [showExportStartedNotification](show-export-started-notification.md) | [androidJvm]<br>open override fun [showExportStartedNotification](show-export-started-notification.md)()<br>Shows a notification of started export |
| [showFailedExportExportNotification](show-failed-export-export-notification.md) | [androidJvm]<br>open override fun [showFailedExportExportNotification](show-failed-export-export-notification.md)()<br>Shows a notification of failed export |
| [showSuccessfulExportNotification](show-successful-export-notification.md) | [androidJvm]<br>open override fun [showSuccessfulExportNotification](show-successful-export-notification.md)(result: [ExportResult.Success](../-export-result/-success/index.md))<br>Shows a notification of successfully finished export. |
