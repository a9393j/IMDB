package com.example.imdb.model

import com.example.imdb.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieNetworkService {

    fun getMovieNetworkService(): MovieAPI {

        val interceptor = Interceptor {
            it.proceed(it.request().newBuilder().addHeader("api_key", Constants.API_KEY).build())
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create<MovieAPI>(MovieAPI::class.java)
    }

}