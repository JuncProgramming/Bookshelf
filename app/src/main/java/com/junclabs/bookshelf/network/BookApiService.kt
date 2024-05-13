package com.junclabs.bookshelf.network

import com.junclabs.bookshelf.model.BookPhoto
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApiService {
    @GET("volumes?q=q")
    suspend fun getPhotos(): List<BookPhoto>
    @GET("volumes/{id}")
    suspend fun getPhoto(@Path("id") id: Int): BookPhoto
}