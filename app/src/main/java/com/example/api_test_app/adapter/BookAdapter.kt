package com.example.api_test_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_test_app.R
import com.example.api_test_app.data.model.Book
import com.example.api_test_app.data.remote.ApiService
import com.example.api_test_app.databinding.ListItemBookBinding
import com.example.api_test_app.ui.CategoriesFragment
import com.example.api_test_app.ui.SharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Request
import org.json.JSONObject
import java.net.URL

class BookAdapter(
    private val books: List<Book>,
    private val viewModel: SharedViewModel
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





        binder.cvBookViewSmall.setOnClickListener {
            viewModel.selectBook(book)
            it.findNavController().navigate(R.id.action_categoriesFragment_to_bookDetailFragment2)
        }
    }


}