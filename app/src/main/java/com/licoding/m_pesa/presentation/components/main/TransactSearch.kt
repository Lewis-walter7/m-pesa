package com.licoding.m_pesa.presentation.components.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.licoding.m_pesa.domain.Constants

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactSearch(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }


    val items = Constants.items
    Surface(
        modifier = Modifier
            .padding(vertical = 10.dp)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        TextField(
                            label = {
                                Text(
                                    text = "Search"
                                )
                            },
                            onValueChange = {
                                name = it
                            },
                            value = name,
                            leadingIcon = {
                                IconButton(
                                    onClick = {
                                        TODO()
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                }
                            },
                            modifier = Modifier.width(300.dp)
                                .background(MaterialTheme.colorScheme.surface)
                                .clip(RoundedCornerShape(50)),
                            trailingIcon = {
                                if (name.isNotEmpty()) {
                                    IconButton(
                                        onClick = {
                                            name = ""
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(18.dp)
                                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                        )
                                    }
                                }
                            }
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 70.dp)
            ) {
                LazyRow {
                    items(items){item ->
                        RowItem(item)
                    }
                }
            }
        }
    }
}

@Composable
fun RowItem(item: String){

    var selected by remember {
        mutableStateOf(false)
    }

    val color = if(selected) Color(0xFF1e9600) else MaterialTheme.colorScheme.background

    Text(
        text = item,
        modifier = Modifier
            .background(color, shape = RoundedCornerShape(35))
            .padding(horizontal = 8.dp, vertical = 5.dp)
            .clickable {
                selected = true
            }
    )
}
