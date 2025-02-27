package com.example.api_test_app.data.model

import com.squareup.moshi.Json

data class Formats (
    @Json(name = "image/jpeg") val image: String,
    @Json(name = "text/plain; charset=utf-8") val text: String?,
)