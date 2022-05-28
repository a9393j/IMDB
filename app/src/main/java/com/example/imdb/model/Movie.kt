package com.example.imdb.model

import retrofit2.http.Field
import java.io.Serializable
import java.util.*

data class Movie (
    val adult: Boolean,
    @Field("back_drop")
    val backdrop: String?,
    val budget: Int,
    val id: Int,
    val overview: String,
    val title: String,
    @Field("release_date")
    val releaseDate: String, // check
    val video: Boolean,
    @Field("vote_average")
    val voteAverage: Double,
    @Field("vote_count")
    val voteCount: Int

) : Serializable
