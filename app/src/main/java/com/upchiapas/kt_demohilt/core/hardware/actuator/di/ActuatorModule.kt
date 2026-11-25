package com.upchiapas.kt_demohilt.core.hardware.actuator.di

import android.content.Context
import android.os.Build
import android.os.Vibrator
import android.os.VibratorManager
import com.upchiapas.kt_demohilt.core.hardware.actuator.data.ActuatorRepositoryImpl
import com.upchiapas.kt_demohilt.core.hardware.actuator.domain.ActuatorRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ActuatorModule {

    @Binds
    @Singleton
    abstract fun bindActuatorRepository(
        impl: ActuatorRepositoryImpl
    ): ActuatorRepository

    companion object {
        @Provides
        @Singleton
        fun provideVibrator(
            @ApplicationContext context: Context
        ): Vibrator? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                vibratorManager?.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
            }
        }
    }
}
