package com.example.api_test_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import coil.load
import com.example.api_test_app.R
import com.example.api_test_app.data.model.Formats
import com.example.api_test_app.databinding.FragmentBookDetailBinding
import com.example.api_test_app.databinding.FragmentCategoriesBinding
import java.lang.System.load

class BookDetailFragment : Fragment() {
    private lateinit var binding: FragmentBookDetailBinding
    private val viewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadBooks()
        viewModel.book.observe(viewLifecycleOwner) {book->
            binding.tvTitle.text = book.title
            binding.tvAuthor.text = book.authors.joinToString{ it.name }
            binding.ivBook.load(book.formats.image)
            val url = book.formats.text

            binding.tvBookshelve.text = buildFormatsString(book.formats)
        }

        binding.imageButton.setOnClickListener {
            it.findNavController().navigateUp()
        }
    }
    private fun buildFormatsString(formats: Formats): String {
        return """
            Text (UTF-8): ${formats.text}
        """.trimIndent()
    }

}