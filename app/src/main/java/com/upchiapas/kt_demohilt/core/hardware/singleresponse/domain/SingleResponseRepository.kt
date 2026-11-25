package com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain

import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.model.SingleResponseModel

interface SingleResponseRepository {
    suspend fun captureSingleResponse(): Result<SingleResponseModel>
    fun isHardwareAvailable(): Boolean
}
