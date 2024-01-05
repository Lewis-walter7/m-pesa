package com.licoding.m_pesa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Fingerprint
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.compose.MPESATheme
import com.licoding.m_pesa.presentation.login.LoginViewModel
import com.licoding.m_pesa.presentation.components.login.Login
import com.licoding.m_pesa.presentation.login.LoginUIEvent
import com.licoding.m_pesa.presentation.utils.DelayFunction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity: FragmentActivity() {
    private val viewModel by viewModels<LoginViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.USE_BIOMETRIC,
                android.Manifest.permission.READ_PHONE_STATE,
                android.Manifest.permission.READ_CONTACTS
            ),
            0
        )
        setContent {
            val phoneNumber = viewModel.getPhoneNumber(this)
            println(phoneNumber)
            val state = viewModel.state.collectAsState()
            val password = state.value.passwordArray.joinToString("")

            val coroutineScope = CoroutineScope(Dispatchers.IO)
            MPESATheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    if(password.isNotEmpty()) {
                                        coroutineScope.launch {
                                            viewModel.OnEvent(LoginUIEvent.OnPasswordDelete)
                                        }
                                    } else {
                                        showBiometricPrompt()
                                    }
                                },
                                modifier = Modifier
                                    .background(MaterialTheme.colorScheme.background)
                                    .padding(horizontal = 10.dp)
                            ) {
                                Icon(
                                    imageVector = if(password.isBlank()) Icons.Rounded.Fingerprint else Icons.Rounded.Close,
                                    contentDescription = "FingerPrint",
                                    tint = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                        }
                    ) {
                            Login(
                                user = viewModel.user,
                                state = state,
                                onEvent = viewModel::OnEvent
                            )
                    }
                }
            }
        }
    }

    private fun showBiometricPrompt() {
        if(isBiometricSupported()){
            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Cancel")
                .build()

            val biometricPrompt = BiometricPrompt(this, ContextCompat.getMainExecutor(this),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        showMessage("Authentication error: $errString")
                    }

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        showMessage("Authentication succeeded!")
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        DelayFunction()
                        startActivity(intent)
                        finish()
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        showMessage("Authentication failed.")
                    }
                })

            biometricPrompt.authenticate(promptInfo)
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun isBiometricSupported(): Boolean {
        val biometricManager = BiometricManager.from(this)
        val canAuthenticate = biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK)
        when (canAuthenticate) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                return true
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE, BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE, BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                return false
            }

            else -> {
                return false
            }
        }
    }
}
