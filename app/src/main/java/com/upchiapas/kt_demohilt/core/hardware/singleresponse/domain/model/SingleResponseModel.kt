package com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.model

data class SingleResponseModel(
    val metadata: String,
    val timestamp: Long = System.currentTimeMillis()
)
