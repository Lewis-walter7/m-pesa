package com.licoding.m_pesa.presentation.components.main.transact

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.licoding.m_pesa.data.model.transact.TransactClass


@Composable
fun Wallet(navController: NavController) {
    val breakPointIndex = 7
    val sentence = "POCH LA BIASHARA"
    val label = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 15.sp)) {
            append(sentence.substring(0, breakPointIndex))
        }
        append("\n")
        withStyle(style = SpanStyle(fontSize = 15.sp)) {
            append(sentence.substring(breakPointIndex))
        }
    }.toString()

    val items = listOf(
        TransactClass(
            label = label,
            icon = Icons.Default.Wallet,
            route = "pochilabiashara",
            color = Color.Magenta,
            image = null,
            url = "https://play.kotlinlang.org/"
        )
    )

    Column {
        Text(
            text = "WALLETS"
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            items.forEachIndexed { index, item ->
                TransactionItem(item, navController, index)
            }
        }
    }
}