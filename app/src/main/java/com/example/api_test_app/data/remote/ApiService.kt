package com.example.api_test_app.data.remote

import com.example.api_test_app.data.model.Book
import com.example.api_test_app.data.model.GutendexResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://gutendex.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("/books")
    suspend fun getBooks(): GutendexResponse

    @GET("/books/{id}")
    suspend fun getBookById(@Path("id") bookId: String): Book
}

object BookApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}