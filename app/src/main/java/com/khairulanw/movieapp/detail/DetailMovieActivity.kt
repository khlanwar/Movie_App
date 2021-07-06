package com.khairulanw.movieapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.khairulanw.movieapp.R
import com.khairulanw.movieapp.core.domain.model.Movie
import com.khairulanw.movieapp.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            with(binding.content){
            tvDetailDescription.text = detailMovie.description
            tvDetailRelease.text = detailMovie.releaseDate
            tvDetailRating.text = detailMovie.rating.toString()
            tvDetailLanguage.text = detailMovie.originalLanguage
            tvDetailOriginalTitle.text = detailMovie.origitalTitle
            tvDetailPopularity.text = detailMovie.popularity.toString()
            tvDetailVote.text = detailMovie.vote.toString()
            }

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500/${detailMovie.poster}")
                .into(binding.content.tvDetailImage)

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w780/${detailMovie.image}")
                .into(binding.ivDetailImage)

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
