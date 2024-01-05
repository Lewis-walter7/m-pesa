package com.licoding.m_pesa.presentation.login

sealed interface LoginUIEvent {
    data class OnNumberChange(var number:String): LoginUIEvent
    object OnPasswordDelete: LoginUIEvent
}