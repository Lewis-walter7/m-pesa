package com.licoding.m_pesa.presentation.components.main.transact

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.licoding.m_pesa.data.model.transact.TransactClass

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun TransactionItem(item: TransactClass, navController: NavController, index: Int){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .clickable {
                navController.navigate("webview/{item.url}")
            }
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
                item.image?.let {
                    Image(
                        painter = item.image,
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Fit
                    )
                }
                item.icon?.let {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                }
            }
        }
        item.label?.let {
            Text(
                text = it,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


