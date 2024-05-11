package com.junclabs.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookPhoto(
    @SerialName(value = "thumbnail")
    val image: String,
    @SerialName(value = "id")
    val id: String
)
