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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.API.RickMortyApi
import com.example.rickmorty.R
import com.example.rickmorty.RickMortyAdapter
import com.example.rickmorty.RickMortyModels.json.Result
import com.example.rickmorty.databinding.RickMortyItemLayoutBinding
import com.example.rickmorty.databinding.RickMortyListLayoutBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
class RickMortyListLayoutFragment: Fragment() {
    private var _binding: RickMortyListLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var badapter: RickMortyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RickMortyListLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        val rickMortyApi = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickMortyApi::class.java)

        CoroutineScope(IO).launch {
            val response = rickMortyApi.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68")
            withContext(Main) {
                badapter.updateList(response.results)
            }
        }
    }

    private fun setUpRecyclerView() {

        badapter = RickMortyAdapter(
            mutableListOf()
        ).apply {

        }

        binding.rvRickMorty.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvRickMorty.adapter = badapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
