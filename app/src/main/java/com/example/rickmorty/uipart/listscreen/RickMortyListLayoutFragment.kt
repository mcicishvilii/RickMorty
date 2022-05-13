package com.example.rickmorty.uipart.listscreen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.API.RickMortyApi
import com.example.rickmorty.databinding.RickMortyListLayoutBinding
import com.example.rickmorty.helpers.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickMortyListLayoutFragment: Fragment() {
    private var _binding: RickMortyListLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var badapter: RickMortyAdapter
    private val viewModel by viewModels<ListScreenViewModel> ()

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

        viewModel.getCharsLiveData().observe(viewLifecycleOwner){
            badapter.updateList(it)
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
