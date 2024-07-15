package com.example.api_test_app.data.model

import com.squareup.moshi.Json

data class Book(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "authors") val authors: List<Author>,
    @Json(name = "formats") val formats: Formats,
    @Json(name = "bookshelves") val bookshelves: List<String>,
    @Json(name = "languages") val languages: List<String>,
    @Json(name = "subjects") val subjects: List<String>

)