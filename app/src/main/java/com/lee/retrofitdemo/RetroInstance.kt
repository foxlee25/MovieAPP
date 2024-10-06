package com.lee.retrofitdemo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object  RetroInstance {
    private const val baseUrl = "https://freetestapi.com/"

    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

