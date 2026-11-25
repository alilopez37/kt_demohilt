package com.upchiapas.kt_demohilt.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.Hardware
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Hardware : Screen(
        route = "hardware",
        title = "Hardware",
        icon = Icons.Default.Hardware
    )

    data object Posts : Screen(
        route = "posts",
        title = "Posts",
        icon = Icons.AutoMirrored.Filled.Article
    )

    companion object {
        val bottomNavItems = listOf(Hardware, Posts)
    }
}
