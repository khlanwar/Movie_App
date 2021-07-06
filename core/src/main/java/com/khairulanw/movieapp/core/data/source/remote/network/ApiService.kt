package com.khairulanw.movieapp.core.data.source.remote.network

import com.khairulanw.movieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getMovieNowPlaying(
        @Query("api_key") apiKey: String = "enter your api here"
    ) : ListMovieResponse
}