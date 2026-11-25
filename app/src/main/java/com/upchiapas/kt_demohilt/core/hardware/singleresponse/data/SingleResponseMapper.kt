package com.upchiapas.kt_demohilt.core.hardware.singleresponse.data

import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.model.SingleResponseModel

fun String.toDomainSingleResponse(): SingleResponseModel {
    return SingleResponseModel(
        metadata = this,
        timestamp = System.currentTimeMillis()
    )
}
