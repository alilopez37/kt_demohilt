package com.upchiapas.kt_demohilt.core.hardware.actuator.domain

import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.model.ActuatorCommandModel

interface ActuatorRepository {
    fun executeCommand(command: ActuatorCommandModel): Result<Unit>
    fun isActuatorAvailable(): Boolean
}
