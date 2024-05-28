package com.junclabs.bookshelf.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    @SerialName("thumbnail") val thumbnail: String
) {
    val httpsThumbnail: String
        get() = thumbnail.replace("http", "https")
}