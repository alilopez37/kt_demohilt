package com.upchiapas.kt_demohilt.features.hardware.domain.usescases

import com.upchiapas.kt_demohilt.features.hardware.domain.repositories.HardwareRepository
import javax.inject.Inject

class ExecuteActuatorUseCase @Inject constructor(
    private val repository: HardwareRepository
) {
    operator fun invoke(durationMs: Long = 500L): Result<Unit> {
        return repository.executeActuator(durationMs)
    }
}
