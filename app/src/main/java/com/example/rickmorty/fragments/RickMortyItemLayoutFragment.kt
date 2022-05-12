package com.example.rickmorty.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.rickmorty.databinding.RickMortyItemLayoutBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class RickMortyItemLayoutFragment: Fragment() {
    private var _binding: RickMortyItemLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RickMortyItemLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val movieId = requireArguments().getInt(KEY_MOVIE_NAME)
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_MOVIE_NAME = "KEY_MOVIE_NAME"
        fun newInstance(movieId: Int): RickMortyItemLayoutFragment {
            return RickMortyItemLayoutFragment().apply {
                arguments = bundleOf(KEY_MOVIE_NAME to movieId)
            }
        }
    }
}