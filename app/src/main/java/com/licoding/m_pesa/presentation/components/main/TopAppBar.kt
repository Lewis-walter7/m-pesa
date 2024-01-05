package com.licoding.m_pesa.presentation.components.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.NotificationsNone
import androidx.compose.material.icons.rounded.QrCode2
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.licoding.m_pesa.data.model.User1
import com.licoding.m_pesa.presentation.utils.GetTime
import com.licoding.m_pesa.presentation.utils.getCharacter
import java.util.*


@Composable
fun TopAppBar(user: User1, navController: NavController) {
    val nameInitials = getCharacter(user.name)
    val greeting = GetTime()
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val firstname = user.name.split("\\s+".toRegex())[0].uppercase(Locale.ROOT)
    val name = "$firstname \uF44B"
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .background(MaterialTheme.colorScheme.onBackground, shape = CircleShape)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            navController.navigate("profile")
                        }
                ) {
                    Text(
                        text = nameInitials,
                        color = MaterialTheme.colorScheme.background,
                        fontSize = 25.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = greeting,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 13.sp
                    )
                    Text(
                        text = name,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp
                    )

                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    imageVector = Icons.Rounded.NotificationsNone,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.AccessTime,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.QrCode2,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }
}
