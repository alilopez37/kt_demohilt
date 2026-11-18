package com.upchiapas.kt_demohilt.features.jsonplaceholder.domain.repositories

import com.upchiapas.kt_demohilt.features.jsonplaceholder.domain.entities.Posts

interface PostsRepository {
        suspend fun getPosts(): List<Posts>
}