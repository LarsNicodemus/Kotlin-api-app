package com.example.api_test_app.data.model

import com.squareup.moshi.Json

data class GutendexResponse (
    @Json(name = "count")
    val count: Int,

    @Json(name = "results")
    val results: List<Book>
)