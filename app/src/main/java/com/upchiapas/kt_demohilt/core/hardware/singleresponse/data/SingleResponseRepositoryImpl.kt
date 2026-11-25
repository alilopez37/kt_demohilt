package com.upchiapas.kt_demohilt.core.hardware.singleresponse.data

import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.SingleResponseRepository
import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.model.SingleResponseModel
import javax.inject.Inject

class SingleResponseRepositoryImpl @Inject constructor(
    private val dataSource: SingleResponseDataSource
) : SingleResponseRepository {

    override fun isHardwareAvailable(): Boolean {
        return dataSource.isHardwareAvailable()
    }

    override suspend fun captureSingleResponse(): Result<SingleResponseModel> {
        return runCatching {
            dataSource.captureReading().toDomainSingleResponse()
        }
    }
}
