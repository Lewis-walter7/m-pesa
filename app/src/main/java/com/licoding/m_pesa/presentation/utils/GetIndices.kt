package com.licoding.m_pesa.presentation.utils


fun GetIndices(passwordArray: Array<Int>): List<Int> {
    val indexArray = arrayOf(0, 1, 2, 3)

    val passwordCheckArray: List<Int> = emptyList()
    passwordArray.forEachIndexed { index, _ ->
        passwordCheckArray.plus(index)
    }
    return indexArray.intersect(passwordCheckArray).toList()
}