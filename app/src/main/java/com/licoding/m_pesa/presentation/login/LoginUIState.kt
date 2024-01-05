package com.licoding.m_pesa.presentation.login

data class LoginUIState(
    val password: String? = "",
    val passwordArray: Array<Int> = emptyArray<Int>()
)