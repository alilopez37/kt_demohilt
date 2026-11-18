package com.upchiapas.kt_demohilt.features.random

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

@HiltViewModel
class RandomViewModel @Inject constructor() : ViewModel() {
    private val  _number  = MutableStateFlow(0)
    val number = _number.asStateFlow()

    fun onClick() {
        _number.value = Random.nextInt(100)
    }
}