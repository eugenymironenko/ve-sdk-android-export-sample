//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportErrorParser](index.md)/[parse](parse.md)

# parse

[androidJvm]\
abstract fun [parse](parse.md)(t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?): [ExportError](../-export-error/index.md)

Transforms throwable object into [ExportError](../-export-error/index.md). Sometimes throwable may be not detected, so ensure you handle the case when the null is passed into parse() function
