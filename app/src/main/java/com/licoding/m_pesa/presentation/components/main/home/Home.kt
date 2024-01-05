package com.licoding.m_pesa.presentation.components.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.licoding.m_pesa.data.model.User1
import com.licoding.m_pesa.presentation.components.main.TopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(user: User1, navController: NavController){

    Scaffold(
        topBar = {
            TopAppBar(user, navController)
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 80.dp, start = 20.dp, end = 20.dp)
        ) {
            item{
               Balance()
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item{
               FrequentServices()
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "M-PESA STATEMENTS",
                        fontSize = 13.sp
                    )
                    Text(
                        text = "SEE ALL",
                        fontSize = 13.sp,
                        color =Color(0xFF50a400)
                    )
                }
            }
        }
    }
}