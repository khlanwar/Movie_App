package com.khairulanw.movieapp.core.utils

import com.khairulanw.movieapp.core.data.source.local.entity.MovieEntity
import com.khairulanw.movieapp.core.data.source.remote.response.MovieResponse
import com.khairulanw.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                releaseDate = it.releaseDate,
                rating = it.rating,
                originalLanguage = it.originalLanguage,
                origitalTitle = it.origitalTitle,
                popularity = it.popularity,
                vote = it.vote,
                image = it.image,
                poster = it.poster,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }
    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                description = it.description,
                releaseDate = it.releaseDate,
                rating = it.rating,
                originalLanguage = it.originalLanguage,
                origitalTitle = it.origitalTitle,
                popularity = it.popularity,
                vote = it.vote,
                image = it.image,
                poster = it.poster,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: Movie) =
        MovieEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            releaseDate = input.releaseDate,
            rating = input.rating,
            originalLanguage = input.originalLanguage,
            origitalTitle = input.origitalTitle,
            popularity = input.popularity,
            vote = input.vote,
            image = input.image,
            poster = input.poster,
            isFavorite = input.isFavorite
        )
}