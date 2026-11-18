package com.upchiapas.kt_demohilt.features.jsonplaceholder.data.datasources.remote.mapper

import com.upchiapas.kt_demohilt.features.jsonplaceholder.data.datasources.remote.models.PostsDto
import com.upchiapas.kt_demohilt.features.jsonplaceholder.domain.entities.Posts


fun PostsDto.toDomain(): Posts {
    return Posts(
        id = this.id,
        title = this.title,
        body = this.body
    )
}