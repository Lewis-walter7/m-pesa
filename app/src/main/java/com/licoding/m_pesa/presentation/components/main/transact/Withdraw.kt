package com.licoding.m_pesa.presentation.components.main.transact

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.licoding.m_pesa.data.model.transact.TransactClass


@Composable
fun Withdraw(navController: NavController){
    val breakPointIndex = 11
    val sentence = "WITHDRAW AT AGENT"
    val sentence2 = "WITHDRAW AT ATM"
    val label = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 15.sp)) {
            append(sentence.substring(0, breakPointIndex))
        }
        append("\n")
        withStyle(style = SpanStyle(fontSize = 15.sp)) {
            append(sentence.substring(breakPointIndex))
        }
    }.toString()
    val label2 = buildAnnotatedString {
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
            icon = Icons.Default.Store,
            route = "pochilabiashara",
            color = Color(0xffd90075),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = label2,
            icon = Icons.Default.Newspaper,
            route = "pochilabiashara",
            color = Color(0xFFd90075),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "",
            icon =null,
            route = "",
            color = null,
            image = null,
            url = ""
        )
    )

    Column {
        Text(
            text = "PAY",
            textAlign = TextAlign.Start
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(60.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEachIndexed { index, item ->
                TransactionItem(item, navController, index)
            }
        }
    }
}
