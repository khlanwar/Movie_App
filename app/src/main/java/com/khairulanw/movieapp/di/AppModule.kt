package com.khairulanw.movieapp.di

import com.khairulanw.movieapp.core.domain.usecase.MovieInteractor
import com.khairulanw.movieapp.core.domain.usecase.MovieUseCase
import com.khairulanw.movieapp.detail.DetailMovieViewModel
import com.khairulanw.movieapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val useCaseModule = module {
        factory<MovieUseCase> { MovieInteractor(get()) }
    }

    val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailMovieViewModel(get()) }
    }