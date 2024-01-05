package com.licoding.m_pesa.data.model.transact

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class TransactClass(
    val label: String?,
    val image: Painter?,
    val icon: ImageVector?,
    val route: String?,
    val color: Color?,
    val url: String?
)