package com.licoding.m_pesa.presentation.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

@Composable
fun rememberBitmapfromBytes(bytes: ByteArray?): ImageBitmap? {
    if (bytes == null) {
        return null
    }
    return remember(bytes) {
         BitmapFactory.decodeByteArray(bytes, 0, bytes.size).asImageBitmap()
    }
}
