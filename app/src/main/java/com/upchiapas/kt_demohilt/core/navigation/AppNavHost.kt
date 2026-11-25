package com.upchiapas.kt_demohilt.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.upchiapas.kt_demohilt.features.hardware.presentation.screens.HardwareScreen
import com.upchiapas.kt_demohilt.features.jsonplaceholder.presentation.screens.PostsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Hardware.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Hardware.route) {
            HardwareScreen()
        }
        composable(Screen.Posts.route) {
            PostsScreen()
        }
    }
}
