package com.upchiapas.kt_demohilt.features.jsonplaceholder.data.repositories

import android.util.Log
import com.upchiapas.kt_demohilt.features.jsonplaceholder.data.datasources.remote.mapper.toDomain
import com.upchiapas.kt_demohilt.features.jsonplaceholder.domain.entities.Posts
import com.upchiapas.kt_demohilt.features.jsonplaceholder.domain.repositories.PostsRepository
import com.upchiapas.kt_demohilt.features.jsonplaceholder.data.datasources.remote.api.JsonPlaceHolderApi
import javax.inject.Inject


class PostsRepositoryImpl @Inject constructor(
        private val api: JsonPlaceHolderApi
) : PostsRepository {

    override suspend fun getPosts(): List<Posts> {
        val response = api.getPosts()
        Log.d("JsonPlaceHolder",response.toString())
        return response.map { it.toDomain() }
    }
}