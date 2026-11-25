package com.upchiapas.kt_demohilt.features.hardware.domain.entities

sealed interface HardwareData {
    data class GpsLocation(
        val latitude: Double,
        val longitude: Double,
        val altitude: Double,
        val accuracy: Float,
        val timestamp: Long
    ) : HardwareData

    data class SingleResponse(
        val metadata: String,
        val timestamp: Long
    ) : HardwareData
}
