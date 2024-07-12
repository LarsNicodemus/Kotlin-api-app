package com.example.api_test_app.data.model

import com.squareup.moshi.Json

data class Book(
    @Json(name = "title") val title: String,
    @Json(name = "authors") val authors: List<Author>,
    @Json(name = "formats") val formats: Formats

)