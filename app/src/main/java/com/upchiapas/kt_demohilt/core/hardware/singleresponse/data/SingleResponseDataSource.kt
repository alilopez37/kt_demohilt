package com.upchiapas.kt_demohilt.core.hardware.singleresponse.data

import android.content.Context
import android.content.pm.PackageManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SingleResponseDataSource @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val packageManager: PackageManager
) {
    fun isHardwareAvailable(): Boolean {
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
    }

    fun captureReading(): String {
        if (!isHardwareAvailable()) {
            throw IllegalStateException("El hardware de respuesta única no está disponible")
        }
        return "Lectura de respuesta única completada"
    }
}
