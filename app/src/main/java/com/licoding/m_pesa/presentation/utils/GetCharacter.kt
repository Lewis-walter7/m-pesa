package com.licoding.m_pesa.presentation.utils

fun getCharacter(text: String): String{
    val names = text.split("\\s+".toRegex())

    val result = StringBuilder()

    for (name in names) {
        if(name.isNotEmpty()) {
            result.append(name[0].uppercaseChar())
        }
    }
    return result.toString()
}