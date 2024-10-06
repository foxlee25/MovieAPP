package com.lee.retrofitdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MoviesAdapter(emptyList())
        recyclerView.adapter = adapter

        //init adapter and set layout manager
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation
        )

        recyclerView.addItemDecoration(dividerItemDecoration)


        // init retrofit
        // 初始化ViewModel
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val retroService = RetroInstance.getRetroInstance().create(RetroService::class.java)

        // 观察 LiveData，并更新UI

        viewModel.fetchMovies(retroService).observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { movies ->
                    adapter.updateMovies(movies.toList()) // 更新适配器
                    Log.d("MainActivity", "Movie list size: ${movies.size}")
                }
            } else {
                Log.e("MainActivity", "Failed to fetch movies: ${response.message()}")
            }
        })


    }
}



