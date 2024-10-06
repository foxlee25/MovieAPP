package com.lee.retrofitdemo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private var movie: List<MovieItem>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.text_description)
        val yearTextView: TextView = itemView.findViewById(R.id.text_year)
        val idTextView: TextView = itemView.findViewById(R.id.text_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {

        return movie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.titleTextView.text = movie[position].title
        holder.descriptionTextView.text = movie[position].plot
        holder.yearTextView.text = movie[position].year.toString()
        holder.idTextView.text = movie[position].id.toString()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovies(newMovies: List<MovieItem>?) {
        if (newMovies != null) {
            this.movie = newMovies
        }
        notifyDataSetChanged()

    }

}