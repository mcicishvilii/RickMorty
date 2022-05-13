package com.example.rickmorty.uipart.listscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Fresco.initialize(this)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flcontent, RickMortyListLayoutFragment())
            addToBackStack(RickMortyListLayoutFragment::javaClass.name)
            commit()
        }
    }
}