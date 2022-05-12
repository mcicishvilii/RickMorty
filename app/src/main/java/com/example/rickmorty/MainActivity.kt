package com.example.rickmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rickmorty.databinding.ActivityMainBinding
import com.example.rickmorty.databinding.RickMortyItemLayoutBinding
import com.example.rickmorty.fragments.RickMortyItemLayoutFragment
import com.example.rickmorty.fragments.RickMortyListLayoutFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flcontent,RickMortyListLayoutFragment())
            addToBackStack(RickMortyListLayoutFragment::javaClass.name)
            commit()
        }
    }
}