package com.licoding.m_pesa.presentation.components.main.grow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.licoding.m_pesa.data.model.transact.TransactClass

@Composable
fun DiscoverMoreItem(item: TransactClass, index: Int, navController: NavController) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable (
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    handleClick(index, navController)
                }
            )
    ) {
        item.color?.let {
            Modifier.size(50.dp)
                .background(it, shape = CircleShape)
        }?.let { modifier ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
            ) {
                item.image?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
        item.label?.let {
            Text(
                text = it
            )
        }
    }
}

fun handleClick(index: Int, navController: NavController) {
    if (index == 0 ) {
        navController.navigate("faraja")
    } else if (index == 1) {
        navController.navigate("hustlerfund")
    }else if (index == 2) {
        navController.navigate("mali")
    }else if (index == 3) {
        navController.navigate("globalpay")
    }else if (index == 4) {
        navController.navigate("kcbmpesa")
    }else if (index == 5) {
        navController.navigate("mshwari")
    }
}