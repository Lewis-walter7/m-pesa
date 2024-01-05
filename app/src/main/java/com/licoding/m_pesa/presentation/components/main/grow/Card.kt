package com.licoding.m_pesa.presentation.components.main.grow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.licoding.m_pesa.data.model.CardClass

@Composable
fun Card(item: CardClass?) {
    Column(
        modifier = Modifier.padding(10.dp)
            .clip(RoundedCornerShape(3))
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            item?.image?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Fit
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Gray)
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (item != null) {
                    Box(
                        modifier = Modifier.size(50.dp)
                            .background(item.color, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    }
                }
                Spacer(
                    modifier = Modifier.width(10.dp)
                )
                Column {
                    if (item != null) {
                        Text(
                            text = item.name,
                            fontSize = 20.sp
                        )
                    }
                    if (item != null) {
                        Text(
                            text = item.description,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}