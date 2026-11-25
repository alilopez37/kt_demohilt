package com.upchiapas.kt_demohilt.core.hardware.gps.data

import com.upchiapas.kt_demohilt.core.hardware.gps.domain.GpsRepository
import com.upchiapas.kt_demohilt.core.hardware.gps.domain.model.LocationModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GpsRepositoryImpl @Inject constructor(
    private val gpsDataSource: GpsDataSource
) : GpsRepository {

    override fun getLocationStream(intervalMs: Long): Flow<LocationModel> {
        return gpsDataSource.getLocationStream(intervalMs).map { it.toDomain() }
    }

    override fun hasGpsFeature(): Boolean {
        return gpsDataSource.hasGpsFeature()
    }
}
