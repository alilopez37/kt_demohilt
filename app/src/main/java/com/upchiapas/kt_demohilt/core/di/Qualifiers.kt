package com.upchiapas.kt_demohilt.core.di

import jakarta.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RickAndMortyRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class JsonPlaceHolderRetrofit
