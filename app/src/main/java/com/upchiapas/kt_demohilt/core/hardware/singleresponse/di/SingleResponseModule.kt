package com.upchiapas.kt_demohilt.core.hardware.singleresponse.di

import android.content.Context
import android.content.pm.PackageManager
import com.upchiapas.kt_demohilt.core.hardware.singleresponse.data.SingleResponseRepositoryImpl
import com.upchiapas.kt_demohilt.core.hardware.singleresponse.domain.SingleResponseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SingleResponseModule {

    @Binds
    @Singleton
    abstract fun bindSingleResponseRepository(
        impl: SingleResponseRepositoryImpl
    ): SingleResponseRepository

    companion object {
        @Provides
        @Singleton
        fun providePackageManager(
            @ApplicationContext context: Context
        ): PackageManager {
            return context.packageManager
        }
    }
}
