package com.example.imdb.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieAPI {

    @GET("{movie_id}")
    suspend fun getMovies(@Path("movie_id") movieId: String): Call<List<Movie>>
}

