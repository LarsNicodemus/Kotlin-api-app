package com.example.api_test_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_test_app.data.Repository
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    private val repository = Repository()

    val books = repository.books

    fun loadBooks() {
        viewModelScope.launch {
            repository.getBooks()
        }
    }
}