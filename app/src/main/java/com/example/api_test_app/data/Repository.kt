package com.example.api_test_app.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.api_test_app.data.model.Book
import com.example.api_test_app.data.remote.BookApi

class Repository {

    private var _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books
    val position = 0
    private var _book = MutableLiveData<Book>()
    val book: LiveData<Book> = _book
    private val _bookContent = MutableLiveData<String>()
    val bookContent: LiveData<String> = _bookContent
    suspend fun getBooks() {
        val result = BookApi.retrofitService.getBooks()
        _books.postValue(result.results)
    }
    suspend fun getBook(id: Int) {
        val result = BookApi.retrofitService.getBook(id)
        _book.postValue(result)
    }
    suspend fun searchBook(query: String) {
        val result = BookApi.retrofitService.searchBooks(query)
        _books.postValue(result.results)
    }
    fun selectBook(book: Book) {
        _book.value = book
    }
}