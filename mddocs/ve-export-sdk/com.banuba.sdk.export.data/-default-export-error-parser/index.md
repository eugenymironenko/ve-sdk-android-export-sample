//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[DefaultExportErrorParser](index.md)

# DefaultExportErrorParser

[androidJvm]\
class [DefaultExportErrorParser](index.md) : [ExportErrorParser](../-export-error-parser/index.md)

Default implementation of [ExportErrorParser](../-export-error-parser/index.md)

## Constructors

| | |
|---|---|
| [DefaultExportErrorParser](-default-export-error-parser.md) | [androidJvm]<br>fun [DefaultExportErrorParser](-default-export-error-parser.md)() |

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [androidJvm]<br>open override fun [parse](parse.md)(t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?): [ExportError](../-export-error/index.md)<br>Transforms throwable object into [ExportError](../-export-error/index.md). Sometimes throwable may be not detected, so ensure you handle the case when the null is passed into parse() function |
