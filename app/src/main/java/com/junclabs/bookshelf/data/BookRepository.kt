package com.junclabs.bookshelf.data

import com.junclabs.bookshelf.model.BookVolumes
import com.junclabs.bookshelf.network.BookApiService

interface BookRepository {
    suspend fun getPhotos(query: String): BookVolumes
    suspend fun getPhoto(id: String): BookVolumes
}

class NetworkBookRepository(
    private val bookApiService: BookApiService
) : BookRepository {
    override suspend fun getPhotos(query: String): BookVolumes = bookApiService.getPhotos(query = query)
    override suspend fun getPhoto(id: String): BookVolumes = bookApiService.getPhoto(id = id)
}