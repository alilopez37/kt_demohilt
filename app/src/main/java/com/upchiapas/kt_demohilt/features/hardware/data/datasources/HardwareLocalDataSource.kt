package com.upchiapas.kt_demohilt.features.hardware.data.datasources

import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.ActuatorRepository
import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.model.ActuatorCommandModel
import com.upchiapas.kt_demohilt.core.hardware.gps.domain.GpsRepository
import com.upchiapas.kt_demohilt.core.hardware.gps.domain.model.LocationModel
import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.SingleResponseRepository
import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.model.SingleResponseModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class HardwareLocalDataSource @Inject constructor(
    private val gpsRepository: GpsRepository,
    private val singleResponseRepository: SingleResponseRepository,
    private val actuatorRepository: ActuatorRepository
) {
    fun getGpsStream(intervalMs: Long): Flow<LocationModel> {
        return gpsRepository.getLocationStream(intervalMs)
    }

    suspend fun captureSingleResponse(): Result<SingleResponseModel> {
        return singleResponseRepository.captureSingleResponse()
    }

    fun executeActuator(durationMs: Long): Result<Unit> {
        return actuatorRepository.executeCommand(ActuatorCommandModel.Vibrate(durationMs))
    }
}
