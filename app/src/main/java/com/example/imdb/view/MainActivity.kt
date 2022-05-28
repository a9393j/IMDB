package com.example.imdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdb.databinding.ActivityMainBinding
import com.example.imdb.model.LoadingState
import com.example.imdb.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MoviesViewModel by viewModels()
    private val adapter = MovieAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        initializeUI()
        initializeObservers()

        viewModel.onViewReady()
    }

    private fun initializeUI() {
        binding.movieRV.adapter = adapter
        binding.movieRV.layoutManager = LinearLayoutManager(this)
    }

    private fun initializeObservers() {
        viewModel.loadingStateLiveData.observe(this, Observer {
            onLoadingStateChanged(it)
        })

        viewModel.movieListData.observe(this, Observer {
            adapter.updateMovies(it)
        })
    }

    private fun onLoadingStateChanged(state: LoadingState) {
        binding.movieRV.visibility = if (state == LoadingState.LOADED) View.VISIBLE else View.GONE
        binding.errorTV.visibility = if (state == LoadingState.ERROR) View.VISIBLE else View.GONE
        binding.loadingPB.visibility = if (state == LoadingState.LOADING) View.VISIBLE else View.GONE
    }
}