package com.junclabs.bookshelf.model

import com.junclabs.bookshelf.network.VolumeInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookPhoto(
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "volumeinfo")
    val volumeInfo: VolumeInfo
)
