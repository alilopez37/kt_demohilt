package com.upchiapas.kt_demohilt.features.hardware.domain.repositories

import com.upchiapas.kt_demohilt.features.hardware.domain.entities.HardwareData
import kotlinx.coroutines.flow.Flow

interface HardwareRepository {
    fun getGpsLocationStream(intervalMs: Long = 2000L): Flow<HardwareData.GpsLocation>
    suspend fun captureSingleResponse(): Result<HardwareData.SingleResponse>
    fun executeActuator(durationMs: Long = 500L): Result<Unit>
}
