package com.upchiapas.kt_demohilt.features.jsonplaceholder.di

import com.upchiapas.kt_demohilt.features.jsonplaceholder.data.repositories.PostsRepositoryImpl
import com.upchiapas.kt_demohilt.features.jsonplaceholder.domain.repositories.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PostsRepositoryModule {
    @Binds
    abstract fun bindPostsRepository(
        postsRepositoryImpl: PostsRepositoryImpl
    ): PostsRepository
}