package com.example.rickmorty.uipart.listscreen.reos

import androidx.room.PrimaryKey
import com.example.rickmorty.RickMortyModels.PopularResponse
import com.example.rickmorty.helpers.RetrofitHelper
import java.nio.channels.spi.AbstractSelectionKey

class RickRepo {
    suspend fun getChars(apiKey: String):PopularResponse{
        return RetrofitHelper.rickApi.getCharacters(apiKey)
    }

    companion object {
        //this singleton
        private var instance: RickRepo? = null
        fun getInstance(): RickRepo {
            return if (instance != null) {
                instance!!
            } else {
                instance = RickRepo()
                instance!!
            }
        }

    }
}