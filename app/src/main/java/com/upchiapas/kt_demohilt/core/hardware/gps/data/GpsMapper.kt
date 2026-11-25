package com.upchiapas.kt_demohilt.core.hardware.gps.data

import android.location.Location
import com.upchiapas.kt_demohilt.core.hardware.gps.domain.model.LocationModel

fun Location.toDomain(): LocationModel {
    return LocationModel(
        latitude = this.latitude,
        longitude = this.longitude,
        altitude = this.altitude,
        accuracy = this.accuracy,
        timestamp = this.time
    )
}
