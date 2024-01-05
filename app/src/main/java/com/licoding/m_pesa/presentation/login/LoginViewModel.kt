package com.licoding.m_pesa.presentation.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.licoding.m_pesa.data.model.User1
import com.licoding.m_pesa.presentation.utils.GetPhoneNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    val user = User1(
        name = "Lewis Indusa",
        phoneNumber = "254759170624",
        profilePicture = null
    )

    private val _state = MutableStateFlow(LoginUIState())
    val state = _state.asStateFlow()

    suspend fun OnEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.OnNumberChange -> {
                val passwordArray = state.value.passwordArray
                val number = event.number.toInt()

                _state.update {
                    it.copy(
                        passwordArray = passwordArray.plus(number)
                    )
                }
            }
            is LoginUIEvent.OnPasswordDelete -> {
                val passwordArray = state.value.passwordArray
                _state.update {
                    it.copy(
                        passwordArray = passwordArray.copyOfRange(0, passwordArray.size - 1)
                    )
                }
            }
        }
    }

    fun getPhoneNumber(context: Context){
        viewModelScope.launch {
            GetPhoneNumber(context)
        }
    }
}