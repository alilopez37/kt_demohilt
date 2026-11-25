package com.upchiapas.kt_demohilt.core.hardware.actuator.data

import android.os.VibrationEffect
import android.os.Vibrator
import javax.inject.Inject

class ActuatorDataSource @Inject constructor(
    private val vibrator: Vibrator?
) {
    fun isAvailable(): Boolean {
        return vibrator?.hasVibrator() == true
    }

    fun vibrateOneShot(durationMs: Long) {
        val target = vibrator ?: throw IllegalStateException("Motor actuador no disponible")
        if (!target.hasVibrator()) {
            throw IllegalStateException("El actuador no está disponible en este dispositivo")
        }
        target.vibrate(VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    fun vibratePattern(timings: LongArray, repeat: Int) {
        val target = vibrator ?: throw IllegalStateException("Motor actuador no disponible")
        if (!target.hasVibrator()) {
            throw IllegalStateException("El actuador no está disponible en este dispositivo")
        }
        target.vibrate(VibrationEffect.createWaveform(timings, repeat))
    }
}
