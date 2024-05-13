package com.junclabs.bookshelf.data

import com.junclabs.bookshelf.model.BookPhoto
import com.junclabs.bookshelf.network.BookApiService

interface BookRepository {
    suspend fun getPhotos(): List<BookPhoto>
    suspend fun getPhoto(id: Int): BookPhoto
}

class NetworkBookRepository(
    private val bookApiService: BookApiService
) : BookRepository {
    override suspend fun getPhotos(): List<BookPhoto> = bookApiService.getPhotos()
    override suspend fun getPhoto(id: Int): BookPhoto = bookApiService.getPhoto(id = id)
}