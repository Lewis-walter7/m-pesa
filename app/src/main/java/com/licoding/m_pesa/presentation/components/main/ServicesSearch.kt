package com.licoding.m_pesa.presentation.components.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesSearch(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }

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
                                    text = "Search services"
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
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "Search"
                )
            }
        }
    }
}