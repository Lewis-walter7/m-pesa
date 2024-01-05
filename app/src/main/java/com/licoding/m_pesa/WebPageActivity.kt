package com.licoding.m_pesa

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.compose.MPESATheme
import com.licoding.m_pesa.presentation.components.main.WebView

class WebPageActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val url = Intent().getStringExtra("url")
            MPESATheme {
                WebView(navController, url)
            }
        }
    }
}