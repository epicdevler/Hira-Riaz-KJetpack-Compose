package com.epicdevler.hirariaz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.epicdevler.hirariaz.presentation.screens.auth.Login
import com.epicdevler.hirariaz.presentation.screens.home.Home
import com.epicdevler.hirariaz.presentation.screens.home.RecentTransactions
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
        composable(route = NavRoutes.Home.route) { Home(navController) }
        composable(route = NavRoutes.Transaction.route) { RecentTransactions(navController) }

    }
}