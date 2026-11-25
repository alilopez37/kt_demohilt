package com.upchiapas.kt_demohilt.features.hardware.data.repositories

import com.upchiapas.kt_demohilt.features.hardware.data.datasources.HardwareLocalDataSource
import com.upchiapas.kt_demohilt.features.hardware.domain.entities.HardwareData
import com.upchiapas.kt_demohilt.features.hardware.domain.repositories.HardwareRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HardwareRepositoryImpl @Inject constructor(
    private val dataSource: HardwareLocalDataSource
) : HardwareRepository {

    override fun getGpsLocationStream(intervalMs: Long): Flow<HardwareData.GpsLocation> {
        return dataSource.getGpsStream(intervalMs).map { location ->
            HardwareData.GpsLocation(
                latitude = location.latitude,
                longitude = location.longitude,
                altitude = location.altitude,
                accuracy = location.accuracy,
                timestamp = location.timestamp
            )
        }
    }

    override suspend fun captureSingleResponse(): Result<HardwareData.SingleResponse> {
        return dataSource.captureSingleResponse().map { model ->
            HardwareData.SingleResponse(
                metadata = model.metadata,
                timestamp = model.timestamp
            )
        }
    }

    override fun executeActuator(durationMs: Long): Result<Unit> {
        return dataSource.executeActuator(durationMs)
    }
}
