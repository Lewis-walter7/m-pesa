package com.licoding.m_pesa.presentation.components.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.licoding.m_pesa.presentation.login.LoginUIEvent
import com.licoding.m_pesa.presentation.login.LoginUIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction1


@Composable
fun Keyboard(
    state: State<LoginUIState>,
    onEvent: KSuspendFunction1<LoginUIEvent, Unit>
) {
    val password = state.value.passwordArray.joinToString("")
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    println(password)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(320.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(3) { rowIndex ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3){ columnIndex ->
                    val number = (rowIndex * 3 + columnIndex + 1).toString()
                    Number(
                        number = number,
                        onNumberClick = {
                            if (state.value.passwordArray.size <= 3) {
                                coroutineScope.launch {
                                    onEvent(LoginUIEvent.OnNumberChange(number))
                                }
                            }
                        }
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Number(
                "0",
                onNumberClick = {
                    if (state.value.passwordArray.size <= 3) {
                        coroutineScope.launch {
                            onEvent(LoginUIEvent.OnNumberChange("0"))
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun Number(
    number: String,
    onNumberClick: (String) -> Unit?
){
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(MaterialTheme.colorScheme.background)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onNumberClick(number)
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number,
            fontSize = 30.sp,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}
