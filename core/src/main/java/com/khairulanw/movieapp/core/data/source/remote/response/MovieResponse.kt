package com.khairulanw.movieapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val description: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("vote_average")
    val rating: Double? = null,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val origitalTitle: String? = null,
    @SerializedName("popularity")
    val popularity: Double? = null,
    @SerializedName("vote_count")
    val vote: Int? = null,
    @SerializedName("backdrop_path")
    val image: String? = null,
    @SerializedName("poster_path")
    val poster: String? = null
)

