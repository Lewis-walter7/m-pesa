package com.licoding.m_pesa.presentation.components.main.transact

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.licoding.m_pesa.R
import com.licoding.m_pesa.data.model.transact.TransactClass
import java.util.*


@Composable
fun FinancialServices(navController: NavController){
    val items = listOf(
        TransactClass(
            label = "FULIZA",
            image = painterResource(R.drawable.mpesaapplogo),
            route = "fuliza",
            color = MaterialTheme.colorScheme.primary,
            icon = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "KCB M-PESA",
            image = painterResource(R.drawable.kcbmpesalogo),
            route = "kcbmpesa",
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            icon = null,
            url = "https://play.kotlinlang.org/"
        ),
        TransactClass(
            label = "M-SHWARI",
            image = painterResource(R.drawable.mshwarilogo),
            route = "mshwari",
            color = Color.Green,
            icon = null,
            url = "https://play.kotlinlang.org/"
        )
    )

    Column {
        Text(
            text = "Financial Services".uppercase(Locale.ROOT),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEachIndexed {index, item ->
                TransactionItem(item, navController, index)
            }
        }
    }
}