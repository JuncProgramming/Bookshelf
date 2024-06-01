package com.junclabs.bookshelf.network

import com.junclabs.bookshelf.model.BookPhoto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApiService {
    @GET("volumes")
    suspend fun getPhotos(@Query("q") query: String = "juncewicz"): List<BookPhoto>
    @GET("volumes/{id}")
    suspend fun getPhoto(@Path("id") id: String = "94vftwEACAAJ"): BookPhoto
}