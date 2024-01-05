package com.licoding.m_pesa.presentation.components.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.licoding.m_pesa.data.model.User1
import com.licoding.m_pesa.presentation.login.LoginUIEvent
import com.licoding.m_pesa.presentation.login.LoginUIState
import kotlin.reflect.KSuspendFunction1

@Composable
fun Login(
    user: User1,
    state: State<LoginUIState>,
    onEvent: KSuspendFunction1<LoginUIEvent, Unit>
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileInfo(user)
        Input(
            state
        )
        Keyboard(
            state = state,
            onEvent = onEvent
        )
    }
}