package com.example.imdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb.model.LoadingState
import com.example.imdb.model.Movie
import com.example.imdb.model.MovieNetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    val movieListData = MutableLiveData<List<Movie>>()
    val loadingStateLiveData = MutableLiveData<LoadingState>()

    private fun getMovieInfo() {


    }

    fun onViewReady() {
        if (movieListData.value.isNullOrEmpty())
            fetchMovies()
    }

    private fun fetchMovies() {
        loadingStateLiveData.value = LoadingState.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                val movieService = MovieNetworkService().getMovieNetworkService()
//                val movie = movieService.getMovies("movieId")
//                movieListData.postValue(movie as List<Movie>)
                movieListData.postValue(generateMovies())
                loadingStateLiveData.postValue(LoadingState.LOADED)
            } catch (e: Exception) {
                loadingStateLiveData.postValue(LoadingState.ERROR)
            }
        }
    }

    private fun generateMovies() : List<Movie> {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        movies.add(Movie(false, "backDrop", 100_000, 1, "Description of the movie", "Movie Title","21-12-2011", false, 2.3, 123))
        return movies
    }

}