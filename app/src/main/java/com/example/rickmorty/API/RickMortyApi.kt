package com.example.rickmorty.API

import com.example.rickmorty.RickMortyModels.PopularResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyApi {

    @Headers("platform: Web")
    @GET("character")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String
    ): PopularResponse
}