package com.upchiapas.kt_demohilt.core.hardware.gps.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class GpsDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val locationManager: LocationManager?
) {
    fun hasGpsFeature(): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS) ||
                context.packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION)
    }

    fun getLocationStream(intervalMs: Long): Flow<Location> = callbackFlow {
        val hasFinePermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val hasCoarsePermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasFinePermission && !hasCoarsePermission) {
            close(SecurityException("Permisos de ubicación no concedidos"))
            return@callbackFlow
        }

        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                trySend(location)
            }

            @Deprecated("Deprecated in Java API")
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        val provider = when {
            locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true -> LocationManager.GPS_PROVIDER
            locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true -> LocationManager.NETWORK_PROVIDER
            else -> null
        }

        if (provider != null) {
            try {
                val lastKnownLocation = locationManager?.getLastKnownLocation(provider)
                if (lastKnownLocation != null) {
                    trySend(lastKnownLocation)
                }

                locationManager?.requestLocationUpdates(
                    provider,
                    intervalMs,
                    1.0f,
                    listener,
                    context.mainLooper
                )
            } catch (e: Exception) {
                close(e)
            }
        } else {
            close(IllegalStateException("No hay proveedores de ubicación activos"))
        }

        awaitClose {
            locationManager?.removeUpdates(listener)
        }
    }
}
