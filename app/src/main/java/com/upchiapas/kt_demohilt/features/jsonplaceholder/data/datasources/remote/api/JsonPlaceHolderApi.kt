package com.upchiapas.kt_demohilt.features.jsonplaceholder.data.datasources.remote.api

import com.upchiapas.kt_demohilt.features.jsonplaceholder.data.datasources.remote.models.PostsDto
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("posts")
    suspend fun getPosts(): List<PostsDto>
}