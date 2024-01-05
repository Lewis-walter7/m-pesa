package com.licoding.m_pesa.presentation.components.main.grow

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.licoding.m_pesa.R
import com.licoding.m_pesa.data.model.transact.TransactClass


@Composable
fun DiscoverMore(navController: NavController) {
    val items = listOf(
        TransactClass(
            label = "FARAJA",
            image = painterResource(R.drawable.farajaicon),
            icon = null,
            route = null,
            color = Color(0xFFc86700),
            url = null
        ),
        TransactClass(
            label = "HUSTLER FUND",
            image = painterResource(R.drawable.hustlerfundicon),
            icon = null,
            route = null,
            color = Color.White,
            url = null
        ),
        TransactClass(
            label = "MALI",
            image = painterResource(R.drawable.kcbmpesalogo),
            icon = null,
            route = null,
            color = Color(0xFF005faf),
            url = null
        )
    )

    val items2 = listOf(
        TransactClass(
            label = "GLOBAL PAY",
            image = painterResource(R.drawable.kcbmpesalogo),
            icon = null,
            route = null,
            color = Color(0xFF50a400),
            url = null
        ),
        TransactClass(
            label = "KCB M-PESA",
            image = painterResource(R.drawable.kcbmpesalogo),
            icon = null,
            route = null,
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            url = null
        ),
        TransactClass(
            label = "M-SHWARI",
            image = painterResource(R.drawable.mshwarilogo),
            icon = null,
            route = null,
            color = Color.White,
            url = null
        )
    )

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = "DISCOVER MORE",
            fontSize = 15.sp
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ) {
            items.forEachIndexed { index, item ->
                DiscoverMoreItem(item, index, navController)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            items2.forEachIndexed { index, item ->
                DiscoverMoreItem(item, index, navController)
            }
        }
    }
}