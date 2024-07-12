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

    fun loadBooks() {
        viewModelScope.launch {

            try {
                repository.getBooks()
            } catch (e: Exception) {
                Log.e("SharedViewModel", "Error loading books", e)
            }
        }
    }
}