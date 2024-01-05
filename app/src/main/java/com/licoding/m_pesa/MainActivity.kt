package com.licoding.m_pesa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.LeakAdd
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.MPESATheme
import com.licoding.m_pesa.data.model.BottomNavigationItem
import com.licoding.m_pesa.presentation.components.main.*
import com.licoding.m_pesa.presentation.components.main.home.Home
import com.licoding.m_pesa.presentation.components.main.profile.Profile
import com.licoding.m_pesa.presentation.main.MainViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    var userInteractionTimestamp: Long = 0
    val inactivityTimeout: Long = 3 * 60 * 1000 // 3 minutes in milliseconds
    private val timer = Timer()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SetJavaScriptEnabled")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MPESATheme {
                // A surface container using the 'background' color from the theme

                val items = listOf(
                    BottomNavigationItem(
                        label = "Home",
                        icon = Icons.Default.Home,
                        route = "home"
                    ),
                     BottomNavigationItem(
                         label = "Transact",
                         icon = Icons.Default.CompareArrows,
                         route = "transact"
                    ),
                     BottomNavigationItem(
                         label = "Services",
                         icon = Icons.Outlined.LeakAdd,
                         route = "services"
                    ),
                     BottomNavigationItem(
                         label = "Grow",
                         icon = Icons.Default.Home,
                         route = "growscreen"
                    )
                )

                var selectedIndex by remember {
                    mutableIntStateOf(0)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomAppBar {
                                items.forEachIndexed { index, item ->
                                   NavigationBarItem(
                                       icon = {
                                           Icon(
                                               imageVector =  item.icon,
                                               contentDescription = null
                                           )
                                       },
                                       onClick = {
                                           selectedIndex = index
                                           navController.navigate(item.route)
                                       },
                                       selected = index == selectedIndex,
                                       label = {
                                           Text(
                                               text = item.label
                                           )
                                       }
                                   )
                                }
                            }
                        }
                    ) {
                        Column(
                            modifier = Modifier.padding(it)
                        ) {
                            NavHost(navController = navController, startDestination = "home") {
                                composable("home") {
                                    Home(viewModel.user, navController)
                                }
                                navigation(
                                    startDestination = "display1",
                                    route = "transact"
                                ) {
                                    composable("display1") {
                                        Transact(navController)
                                    }
                                    composable("transactsearch") {
                                        TransactSearch(navController)
                                    }
                                }
                                navigation(
                                    startDestination = "display",
                                    route = "services"
                                ) {
                                    composable("display") {
                                        Services(navController)
                                    }
                                    composable("servicessearch") {
                                        ServicesSearch(navController)
                                    }
                                }
                                navigation(
                                    startDestination = "grow",
                                    route = "growscreen"
                                ) {
                                    composable("grow") {
                                        Grow(navController)
                                    }
                                    composable("faraja") {
                                        Grow(navController)
                                    }
                                    composable("hustlerfund") {
                                        Grow(navController)
                                    }
                                    composable("mali") {
                                        Grow(navController)
                                    }
                                    composable("globalpay") {
                                        Grow(navController)
                                    }
                                    composable("kcbmpesa") {
                                        Grow(navController)
                                    }
                                    composable("mshwari") {
                                        Grow(navController)
                                    }
                                }
                                composable("profile") {
                                    Profile(navController)
                                }
                                composable(
                                    "webview/{url}",
                                    arguments = listOf(
                                        navArgument(
                                            name = "url"
                                        ) {
                                            type = NavType.StringType
                                        }
                                    )
                                ) { navStackEntry ->
                                    val url = navStackEntry.arguments?.getString("url")
                                    WebView(navController, url)
                                }
                            }
                        }
                    }
                }
            }
        }

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val currentTime = System.currentTimeMillis()
                if (currentTime - userInteractionTimestamp > inactivityTimeout) {
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                    finish()
                }
            }
        }, inactivityTimeout, inactivityTimeout)
    }

    fun startWebActivity(){
        startActivity(Intent(this@MainActivity, WebPageActivity::class.java))
    }
    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        userInteractionTimestamp = System.currentTimeMillis()
    }
}
