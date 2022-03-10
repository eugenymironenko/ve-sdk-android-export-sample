//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[SimpleExportParamsProvider](index.md)/[provideExportParams](provide-export-params.md)

# provideExportParams

[androidJvm]\
open override fun [provideExportParams](provide-export-params.md)(effects: Effects, videoRangeList: VideoRangeList, musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, videoVolume: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportParams](../-export-params/index.md)&gt;

Provides a list of [ExportParams](../-export-params/index.md) objects. Every ExportParams object represents params applied to single exported video. By providing one ExportParams inside list you requests one exported video. When [ExportParamsProvider](../-export-params-provider/index.md) is utilized as a part of Video Editor SDK all parameters are provided from normal Video Editor flow. If you use only export functionality without Video Editor flow, you should create all input parameters by yourself.

## Parameters

androidJvm

| | |
|---|---|
| effects | visual and time effects applied to videos to be exported |
| videoRangeList | video clips to be exported into single video |
| musicEffects | music effects applied to videos |
| videoVolume | video volume |
