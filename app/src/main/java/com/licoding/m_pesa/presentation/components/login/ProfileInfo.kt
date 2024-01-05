package com.licoding.m_pesa.presentation.components.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.licoding.m_pesa.data.model.User1
import com.licoding.m_pesa.presentation.utils.getCharacter
import com.licoding.m_pesa.presentation.utils.rememberBitmapfromBytes

@Composable
fun ProfileInfo(user: User1) {

    val name = getCharacter(user.name)
    val profileImage = rememberBitmapfromBytes(user.profilePicture)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (profileImage != null) {
            Image(
                bitmap = profileImage,
                contentDescription = null,
                modifier = Modifier.size(50.dp)
                    .clip(RoundedCornerShape(50))
                    .aspectRatio(1f)
            )
        } else {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(MaterialTheme.colorScheme.onBackground, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name,
                    color = Color.Blue,
                    fontSize = 20.sp,
                )
            }
        }
        Text(
            text = user.name,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = user.phoneNumber,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

