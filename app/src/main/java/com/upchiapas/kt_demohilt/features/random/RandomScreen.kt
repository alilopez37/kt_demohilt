package com.upchiapas.kt_demohilt.features.random


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RandomScreen(
    viewModel: RandomViewModel = hiltViewModel()
) {
    val number by viewModel.number.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("$number")
        Button(
            onClick = {viewModel.onClick()}
        ) {
            Text("Click")
        }
    }
}