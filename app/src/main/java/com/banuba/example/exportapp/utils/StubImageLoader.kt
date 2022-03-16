package com.banuba.example.exportapp.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.banuba.sdk.core.domain.ImageLoader

class StubImageLoader : ImageLoader {

    override fun loadThumbnail(
        view: ImageView,
        uri: Uri,
        placeholderRes: Int?,
        errorPlaceholderRes: Int?,
        isCircle: Boolean,
        onResourceReady: (Drawable) -> Unit,
        onFailed: () -> Unit
    ) {
    }

    override fun loadImage(
        view: ImageView,
        uri: Uri,
        placeholderRes: Int?,
        errorPlaceholderRes: Int?,
        isCircle: Boolean,
        cornerRadiusPx: Int,
        skipCache: Boolean
    ) {
    }

    override fun getImageBitmap(uri: Uri, skipCache: Boolean): Bitmap {
        return Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888)
    }

    override fun loadSticker(
        view: ImageView,
        uri: Uri,
        isHiRes: Boolean,
        width: Int,
        height: Int
    ) {
    }

    override fun loadGif(view: ImageView, uri: Uri, onResourceReady: (Drawable) -> Unit) {}
}