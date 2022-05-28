package com.example.imdb.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb.databinding.MovieItemBinding
import com.example.imdb.model.Movie

class MovieAdapter(private val movies: ArrayList<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    fun updateMovies(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
//            binding.movieThumbnail.setImageDrawable() = movie.id.toString()
            binding.movieName.text = movie.title.toString()
            binding.movieDescription.text = movie.overview.toString()
        }
    }
}