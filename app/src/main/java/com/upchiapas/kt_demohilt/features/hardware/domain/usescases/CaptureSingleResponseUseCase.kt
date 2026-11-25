package com.upchiapas.kt_demohilt.features.hardware.domain.usescases

import com.upchiapas.kt_demohilt.features.hardware.domain.entities.HardwareData
import com.upchiapas.kt_demohilt.features.hardware.domain.repositories.HardwareRepository
import javax.inject.Inject

class CaptureSingleResponseUseCase @Inject constructor(
    private val repository: HardwareRepository
) {
    suspend operator fun invoke(): Result<HardwareData.SingleResponse> {
        return repository.captureSingleResponse()
    }
}
