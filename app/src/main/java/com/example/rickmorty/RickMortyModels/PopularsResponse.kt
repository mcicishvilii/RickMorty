package com.example.rickmorty.RickMortyModels

import com.example.rickmorty.RickMortyModels.json.Result
import com.google.gson.annotations.SerializedName

data class PopularResponse(
        @SerializedName("page")
        val page:Int,
        @SerializedName("results")
        val results:List<Result>
        )
