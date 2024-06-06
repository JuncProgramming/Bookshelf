package com.junclabs.bookshelf.model

data class BookVolumes(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)