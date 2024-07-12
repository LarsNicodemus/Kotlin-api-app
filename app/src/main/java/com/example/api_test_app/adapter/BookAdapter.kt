package com.example.api_test_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_test_app.data.model.Book
import com.example.api_test_app.databinding.ListItemBookBinding

class BookAdapter(
    private val books: List<Book>
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    inner class BookViewHolder(val binding: ListItemBookBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ListItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        val binder = holder.binding
        binder.tvTitle.text = book.title
        val imageUrl = book.formats.image
        binder.tvAuthor.text = book.authors.joinToString { it.name }
        binder.ivBook.load(imageUrl)
    }


}