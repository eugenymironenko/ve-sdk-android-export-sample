//[ve-export-sdk](../../../../index.md)/[com.banuba.sdk.export.data](../../index.md)/[ExportResult](../index.md)/[Error](index.md)

# Error

[androidJvm]\
data class [Error](index.md)(type: [ExportError](../../-export-error/index.md)) : [ExportResult](../index.md), [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

Means that error was happened during export

## Parameters

androidJvm

| | |
|---|---|
| type | [ExportError](../../-export-error/index.md) object |

## Constructors

| | |
|---|---|
| [Error](-error.md) | [androidJvm]<br>fun [Error](-error.md)(type: [ExportError](../../-export-error/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [describeContents](../../-exported-video/index.md#-1578325224%2FFunctions%2F545878494) | [androidJvm]<br>abstract fun [describeContents](../../-exported-video/index.md#-1578325224%2FFunctions%2F545878494)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [writeToParcel](../../-exported-video/index.md#-1754457655%2FFunctions%2F545878494) | [androidJvm]<br>abstract fun [writeToParcel](../../-exported-video/index.md#-1754457655%2FFunctions%2F545878494)(p0: [Parcel](https://developer.android.com/reference/kotlin/android/os/Parcel.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [androidJvm]<br>val [type](type.md): [ExportError](../../-export-error/index.md) |
