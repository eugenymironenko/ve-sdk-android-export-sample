//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportErrorParser](index.md)

# ExportErrorParser

[androidJvm]\
interface [ExportErrorParser](index.md)

Interface for parsing export errors

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [androidJvm]<br>abstract fun [parse](parse.md)(t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?): [ExportError](../-export-error/index.md)<br>Transforms throwable object into [ExportError](../-export-error/index.md). Sometimes throwable may be not detected, so ensure you handle the case when the null is passed into parse() function |

## Inheritors

| Name |
|---|
| [DefaultExportErrorParser](../-default-export-error-parser/index.md) |
