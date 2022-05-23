package com.epicdevler.hirariaz.utils

sealed class NavRoutes(val route: String) {
    object Login : NavRoutes("login")
    object Transaction : NavRoutes("transaction")
    object Home : NavRoutes("home")
}