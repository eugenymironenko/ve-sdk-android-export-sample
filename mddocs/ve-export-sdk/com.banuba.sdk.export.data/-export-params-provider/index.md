//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[ExportParamsProvider](index.md)

# ExportParamsProvider

[androidJvm]\
interface [ExportParamsProvider](index.md)

Interface which customizes requested export.

## Functions

| Name | Summary |
|---|---|
| [provideExportParams](provide-export-params.md) | [androidJvm]<br>abstract fun [provideExportParams](provide-export-params.md)(effects: Effects, videoRangeList: VideoRangeList, musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, videoVolume: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportParams](../-export-params/index.md)&gt;<br>Provides a list of [ExportParams](../-export-params/index.md) objects. Every ExportParams object represents params applied to single exported video. By providing one ExportParams inside list you requests one exported video. When [ExportParamsProvider](index.md) is utilized as a part of Video Editor SDK all parameters are provided from normal Video Editor flow. If you use only export functionality without Video Editor flow, you should create all input parameters by yourself. |

## Inheritors

| Name |
|---|
| [SimpleExportParamsProvider](../-simple-export-params-provider/index.md) |
