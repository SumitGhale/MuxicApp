package com.example.muxicapp

import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

val retrofit = Builder()
    .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val artistSongs = retrofit.create(ApiService::class.java)
interface ApiService {

    @Headers(
        "x-rapidapi-key: 97db46e7d3mshcb6455f6e5e4b6cp1c46d0jsn107b443e3af1",
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com"
    )

    @GET("search")
    suspend fun getSongs(@Query("q") artistName: String): Data
}