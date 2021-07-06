package com.khairulanw.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String?,
    val description: String?,
    val releaseDate: String?,
    val rating: Double?,
    val originalLanguage: String?,
    val origitalTitle: String?,
    val popularity: Double?,
    val vote: Int?,
    val image: String?,
    val poster: String?,
    val isFavorite: Boolean
) : Parcelable