package com.lee.retrofitdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import retrofit2.Response



class MainViewModel : ViewModel() {

    fun fetchMovies(retroService: RetroService): LiveData<Response<Movies>> = liveData {
        val response: Response<Movies> = retroService.getMovieList()
        emit(response) // 发射数据
    }
}