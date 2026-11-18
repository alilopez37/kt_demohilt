package com.upchiapas.kt_demohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.upchiapas.kt_demohilt.features.jsonplaceholder.presentation.screens.PostsScreen
import com.upchiapas.kt_demohilt.ui.theme.Kt_demohiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kt_demohiltTheme {
                PostsScreen()
            }
        }
    }
}

