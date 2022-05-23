package com.epicdevler.hirariaz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.epicdevler.hirariaz.presentation.screens.auth.Login
import com.epicdevler.hirariaz.presentation.screens.home.Home
import com.epicdevler.hirariaz.presentation.ui.theme.BodyBackground
import com.epicdevler.hirariaz.presentation.ui.theme.HiraRiazTheme
import com.epicdevler.hirariaz.utils.NavRoutes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            HiraRiazTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BodyBackground,
                ) {
                    NavigationHolder()
                }
            }
        }
    }
}

@Composable
fun NavigationHolder() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login.route
    ) {
        composable(route = NavRoutes.Login.route) { Login(navController) }
        composable(route = NavRoutes.Home.route) { Home() }
        composable(route = NavRoutes.Transaction.route) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Hello, Transaction screen here")
            }
        }

    }
}