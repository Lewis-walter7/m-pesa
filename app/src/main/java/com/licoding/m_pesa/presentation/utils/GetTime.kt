package com.licoding.m_pesa.presentation.utils

import java.util.*

fun GetTime(): String {
    val calendar = Calendar.getInstance()
    val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

    return when (hourOfDay) {
        in 0..11 -> "Good morning,"
        in 12..17 -> "Good afternoon,"
        else -> "Good evening,"
    }
}