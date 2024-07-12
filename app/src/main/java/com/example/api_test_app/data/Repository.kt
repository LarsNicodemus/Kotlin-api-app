package com.example.api_test_app.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.api_test_app.data.model.Book
import com.example.api_test_app.data.remote.BookApi

class Repository {

    private var _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    suspend fun getBooks() {
        val result = BookApi.retrofitService.getBooks()
        _books.postValue(result.books)
    }
}