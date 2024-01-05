package com.licoding.m_pesa.presentation.components.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.licoding.m_pesa.presentation.login.LoginUIState
import com.licoding.m_pesa.presentation.utils.GetIndices

@Composable
fun Input(state: State<LoginUIState>) {

    val passwordArray = state.value.passwordArray

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Enter Password:",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            (1..4).forEachIndexed{ index, _ ->
//                RadioButton(
//                    selected = true,
//                    onClick = null,
//                    modifier = Modifier
//                        .size(50.dp)
//                        .scale(2f)
//                )
                PasswordInput(index, passwordArray)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(index: Int, passwordArray: Array<Int>) {

    val indices = GetIndices(passwordArray)
    println(indices)
    val color = if (indices.contains(index)) Color(0xFF50a400) else MaterialTheme.colorScheme.background

    OutlinedTextField(
        value = "",
        onValueChange = {
            println("Ohbsh")
        },
        modifier = Modifier
            .size(50.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(50))
            .background(color = Color(0xFF50a400), shape = CircleShape)
            .border(1.dp, color = MaterialTheme.colorScheme.onBackground),
        visualTransformation = PasswordVisualTransformation(),
        enabled = false
    )
}
