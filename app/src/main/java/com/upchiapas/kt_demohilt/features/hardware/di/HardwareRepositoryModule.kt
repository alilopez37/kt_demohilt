package com.upchiapas.kt_demohilt.features.hardware.di

import com.upchiapas.kt_demohilt.features.hardware.data.repositories.HardwareRepositoryImpl
import com.upchiapas.kt_demohilt.features.hardware.domain.repositories.HardwareRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HardwareRepositoryModule {

    @Binds
    abstract fun bindHardwareRepository(
        hardwareRepositoryImpl: HardwareRepositoryImpl
    ): HardwareRepository
}
