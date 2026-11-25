package com.upchiapas.kt_demohilt.core.hardware.gps.domain.model

data class LocationModel(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double = 0.0,
    val accuracy: Float = 0.0f,
    val timestamp: Long = System.currentTimeMillis()
)
