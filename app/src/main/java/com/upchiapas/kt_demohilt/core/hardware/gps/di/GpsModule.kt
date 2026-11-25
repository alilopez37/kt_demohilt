package com.upchiapas.kt_demohilt.core.hardware.gps.di

import android.content.Context
import android.location.LocationManager
import com.upchiapas.kt_demohilt.core.hardware.gps.data.GpsRepositoryImpl
import com.upchiapas.kt_demohilt.core.hardware.gps.domain.GpsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GpsModule {

    @Binds
    @Singleton
    abstract fun bindGpsRepository(
        impl: GpsRepositoryImpl
    ): GpsRepository

    companion object {
        @Provides
        @Singleton
        fun provideLocationManager(
            @ApplicationContext context: Context
        ): LocationManager? {
            return context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager
        }
    }
}
