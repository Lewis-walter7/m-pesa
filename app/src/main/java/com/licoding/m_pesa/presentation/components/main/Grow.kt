package com.licoding.m_pesa.presentation.components.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.licoding.m_pesa.presentation.components.main.grow.DiscoverMore
import com.licoding.m_pesa.presentation.components.main.grow.Highlighted

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Grow(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "GROW",
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                .padding(10.dp)
        ) {
            Highlighted()
            Spacer(modifier = Modifier.height(20.dp))
            DiscoverMore(navController)
        }
    }
}