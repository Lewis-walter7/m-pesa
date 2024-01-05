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
fun Pay(navController: NavController) {

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
            label = "SEND MONEY",
            icon = Icons.Default.Receipt,
            route = "pochilabiashara",
            color = Color(0xff005faf),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "BUY GOODS",
            icon = Icons.Default.Restore,
            route = "pochilabiashara",
            color = Color(0xFF005faf),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = label,
            icon = Icons.Default.PhoneAndroid,
            route = "pochilabiashara",
            color = Color(0xFF005faf),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
    )

    val items2 = listOf(
        TransactClass(
            label = "SEND TO MANY",
            icon = Icons.Default.Wallet,
            route = "pochilabiashara",
            color = Color(0xFF005faf),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "",
            icon = null,
            route = "",
            color = null,
            image = null,
            url = ""
        ),
        TransactClass(
            label = "",
            icon = null,
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
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            items.forEachIndexed { index, item ->
                TransactionItem(item, navController, index)
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(60.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items2.forEachIndexed { index, item ->
                TransactionItem(item, navController, index)
            }
        }
    }
}
