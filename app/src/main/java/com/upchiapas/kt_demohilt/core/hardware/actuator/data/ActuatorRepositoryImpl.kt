package com.upchiapas.kt_demohilt.core.hardware.actuator.data

import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.ActuatorRepository
import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.model.ActuatorCommandModel
import javax.inject.Inject

class ActuatorRepositoryImpl @Inject constructor(
    private val dataSource: ActuatorDataSource
) : ActuatorRepository {

    override fun isActuatorAvailable(): Boolean {
        return dataSource.isAvailable()
    }

    override fun executeCommand(command: ActuatorCommandModel): Result<Unit> {
        return runCatching {
            command.executeOn(dataSource)
        }
    }
}
