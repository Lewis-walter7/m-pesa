package com.licoding.m_pesa.data.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class CardClass(
    val image: Painter,
    val name: String,
    val description: String,
    val iconImage: Painter,
    val color: Color
)