package com.junclabs.bookshelf.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    @SerialName("imageLinks") val imageLinks: Thumbnail
)