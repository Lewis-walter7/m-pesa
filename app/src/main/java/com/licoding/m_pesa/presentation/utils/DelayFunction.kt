package com.licoding.m_pesa.presentation.utils

import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.*

fun DelayFunction() {
    CoroutineScope(Dispatchers.Default).launch {
        delay(3000)
    }
}