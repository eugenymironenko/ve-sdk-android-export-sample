//[ve-export-sdk](../../../index.md)/[com.banuba.sdk.export.data](../index.md)/[SimpleExportParamsProvider](index.md)

# SimpleExportParamsProvider

[androidJvm]\
class [SimpleExportParamsProvider](index.md)(exportDir: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), mediaFileNameHelper: MediaFileNameHelper, watermarkBuilder: WatermarkBuilder, exportAudioProvider: [EnableExportAudioProvider](../-enable-export-audio-provider/index.md), exportVideoResolutionProvider: [ExportVideoResolutionProvider](../-export-video-resolution-provider/index.md)) : [ExportParamsProvider](../-export-params-provider/index.md)

Default [ExportParamsProvider](../-export-params-provider/index.md) implementation. It requests single exported video and configures request parameters by utilizing [ExportParams.Builder](../-export-params/-builder/index.md).

## Constructors

| | |
|---|---|
| [SimpleExportParamsProvider](-simple-export-params-provider.md) | [androidJvm]<br>fun [SimpleExportParamsProvider](-simple-export-params-provider.md)(exportDir: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), mediaFileNameHelper: MediaFileNameHelper, watermarkBuilder: WatermarkBuilder, exportAudioProvider: [EnableExportAudioProvider](../-enable-export-audio-provider/index.md), exportVideoResolutionProvider: [ExportVideoResolutionProvider](../-export-video-resolution-provider/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [provideExportParams](provide-export-params.md) | [androidJvm]<br>open override fun [provideExportParams](provide-export-params.md)(effects: Effects, videoRangeList: VideoRangeList, musicEffects: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MusicEffect&gt;, videoVolume: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExportParams](../-export-params/index.md)&gt;<br>Provides a list of [ExportParams](../-export-params/index.md) objects. Every ExportParams object represents params applied to single exported video. By providing one ExportParams inside list you requests one exported video. When [ExportParamsProvider](../-export-params-provider/index.md) is utilized as a part of Video Editor SDK all parameters are provided from normal Video Editor flow. If you use only export functionality without Video Editor flow, you should create all input parameters by yourself. |
