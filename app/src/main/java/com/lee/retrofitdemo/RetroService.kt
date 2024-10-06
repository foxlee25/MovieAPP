package com.lee.retrofitdemo

import retrofit2.Response
import retrofit2.http.GET

interface RetroService {

    @GET("api/v1/movies?limit=5")
    suspend fun getMovieList(): Response<Movies>

}