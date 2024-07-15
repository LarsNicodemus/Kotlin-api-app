package com.example.api_test_app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_test_app.data.Repository
import com.example.api_test_app.data.model.Book
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    private val repository = Repository()

    val books = repository.books
    val book = repository.book
    val bookContent = repository.bookContent

    val searchResults = mutableListOf<Book>()

    fun loadBooks() {
        viewModelScope.launch {

            try {
                repository.getBooks()
            } catch (e: Exception) {
                Log.e("SharedViewModel", "Error loading books", e)
            }
        }
    }
    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                repository.searchBook(query)

            } catch (e: Exception) {
                Log.e("SharedViewModel", "Error loading searched books", e)
            }
        }
    }

    fun selectBook(book: Book) {
        repository.selectBook(book)
    }
    fun loadBook(bookID: Int) {
        viewModelScope.launch {
            try {
                repository.getBook(bookID)
            } catch (e: Exception) {
                Log.e("SharedViewModel", "Error loading book text", e)
            }
        }
    }
}