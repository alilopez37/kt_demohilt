package com.upchiapas.kt_demohilt.core.hardware.gps.domain

import com.upchiapas.kt_demohilt.core.hardware.gps.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow

interface GpsRepository {
    fun getLocationStream(intervalMs: Long = 2000L): Flow<LocationModel>
    fun hasGpsFeature(): Boolean
}
