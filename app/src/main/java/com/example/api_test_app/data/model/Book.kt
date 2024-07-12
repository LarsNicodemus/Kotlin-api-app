package com.example.api_test_app.data.model

data class Book (
    val id : Int,
    val title : String,
    val authors : List<Author>,
    val bookshelves: List<String>,
)