package com.upchiapas.kt_demohilt.core.hardware.actuator.domain.model

sealed interface ActuatorCommandModel {
    data class Vibrate(val durationMs: Long = 500) : ActuatorCommandModel
    data class VibratePattern(val timings: LongArray, val repeat: Int = -1) : ActuatorCommandModel {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as VibratePattern
            if (!timings.contentEquals(other.timings)) return false
            return repeat == other.repeat
        }

        override fun hashCode(): Int {
            var result = timings.contentHashCode()
            result = 31 * result + repeat
            return result
        }
    }
}
