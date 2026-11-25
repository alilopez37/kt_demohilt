package com.upchiapas.kt_demohilt.features.hardware.domain.usescases

import com.upchiapas.kt_demohilt.features.hardware.domain.entities.HardwareData
import com.upchiapas.kt_demohilt.features.hardware.domain.repositories.HardwareRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetGpsLocationStreamUseCase @Inject constructor(
    private val repository: HardwareRepository
) {
    operator fun invoke(intervalMs: Long = 2000L): Flow<HardwareData.GpsLocation> {
        return repository.getGpsLocationStream(intervalMs)
    }
}
