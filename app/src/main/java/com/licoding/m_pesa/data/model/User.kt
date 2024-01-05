package com.licoding.m_pesa.data.model

data class User(
    val phoneNumber: String,
    val name: String,
    val pin: String = "7718",
    val hasEnabledBiometricAuthentication: Boolean = false,
    val hasEnabledFastLogin: Boolean = false,
    val hasEnabledOfflineMde: Boolean = false,
    val profilePicture: ByteArray?
)