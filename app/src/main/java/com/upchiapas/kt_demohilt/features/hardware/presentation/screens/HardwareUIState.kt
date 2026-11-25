package com.upchiapas.kt_demohilt.features.hardware.presentation.screens

import android.graphics.Bitmap
import com.upchiapas.kt_demohilt.features.hardware.domain.entities.HardwareData

data class HardwareUIState(
    val isLoading: Boolean = false,
    val isGpsActive: Boolean = false,
    val gpsLocation: HardwareData.GpsLocation? = null,
    val singleResponse: HardwareData.SingleResponse? = null,
    val capturedImage: Bitmap? = null,
    val statusMessage: String? = null,
    val error: String? = null
)
