package com.licoding.m_pesa.presentation.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.licoding.m_pesa.data.model.User1
import com.licoding.m_pesa.presentation.utils.GetPhoneNumber
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val user = User1(
        name = "Lewis Indusa",
        phoneNumber = "254759170624",
        profilePicture = null
    )
}