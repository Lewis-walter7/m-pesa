package com.licoding.m_pesa.presentation.components.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.licoding.m_pesa.data.model.transact.TransactClass

@Composable
fun FrequentServices() {

    val breakPointIndex = 9
    val anotherNetworkSentence = "SEND AND REQUEST"
    val anotherNetwork = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 15.sp)) {
            append(anotherNetworkSentence.substring(0, breakPointIndex))
        }
        append("\n")
        withStyle(style = SpanStyle(fontSize = 15.sp)) {
            append(anotherNetworkSentence.substring(breakPointIndex))
        }
    }.toString()
    val items = listOf(
        TransactClass(
            label = anotherNetwork,
            icon = Icons.Default.OpenInFull,
            route = "pochilabiashara",
            color = Color(0xFF50a400),
            image = null,
            url = "https://www.google.com/"
        ),
        TransactClass(
            label = "PAY",
            icon = Icons.Default.Receipt,
            route = "pochilabiashara",
            color = Color(0xff005faf),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "WITHDRAW",
            icon = Icons.Default.Store,
            route = "pochilabiashara",
            color = Color(0xffd90075),
            image = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "AIRTIME",
            icon = Icons.Default.Store,
            route = "pochilabiashara",
            color = Color(0xffd90075),
            image = null,
            url = "https://play.kotlinlang.org/"
        )
    )
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { item ->
            TransactItem(item)
        }
    }
}

@Composable
fun TransactItem(item: TransactClass){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item.color?.let {
            Modifier
                .size(40.dp)
                .background(it, shape = CircleShape)
        }?.let {
            Box(
                contentAlignment = Alignment.Center,
                modifier = it
            ) {
                if(item.icon != null) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                } else {
                    item.image?.let { painter ->
                        Image(
                            painter = painter,
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item.label?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                fontSize = 11.sp
            )
        }
    }
}