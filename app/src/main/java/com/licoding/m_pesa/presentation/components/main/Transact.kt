package com.licoding.m_pesa.presentation.components.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.licoding.m_pesa.presentation.components.main.transact.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Transact(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "TRANSACT",
                        textAlign = TextAlign.Center
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("transactsearch")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 70.dp)
        ) {
            item {
                FinancialServices(navController)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Wallet(navController)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                SendAndRequest(navController)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Pay(
                    navController
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Withdraw(
                    navController
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Airtime(navController)
            }
        }
    }
}