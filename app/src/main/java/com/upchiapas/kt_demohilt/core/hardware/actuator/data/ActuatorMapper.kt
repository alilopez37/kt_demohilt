package com.upchiapas.kt_demohilt.core.hardware.actuator.data

import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.model.ActuatorCommandModel

fun ActuatorCommandModel.executeOn(dataSource: ActuatorDataSource) {
    when (this) {
        is ActuatorCommandModel.Vibrate -> dataSource.vibrateOneShot(this.durationMs)
        is ActuatorCommandModel.VibratePattern -> dataSource.vibratePattern(this.timings, this.repeat)
    }
}
