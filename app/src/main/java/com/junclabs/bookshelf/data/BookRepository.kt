package com.junclabs.bookshelf.data

import com.junclabs.bookshelf.model.BookPhoto
import com.junclabs.bookshelf.network.BookApiService

interface BookRepository {
    suspend fun getPhotos(query: String): List<BookPhoto>
    suspend fun getPhoto(id: Int): BookPhoto
}

class NetworkBookRepository(
    private val bookApiService: BookApiService
) : BookRepository {
    override suspend fun getPhotos(query: String): List<BookPhoto> = bookApiService.getPhotos(query = query)
    override suspend fun getPhoto(id: Int): BookPhoto = bookApiService.getPhoto(id = id)
}