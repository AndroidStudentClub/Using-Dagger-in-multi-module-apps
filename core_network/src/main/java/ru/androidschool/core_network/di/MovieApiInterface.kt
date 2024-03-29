package ru.androidschool.core_network.di

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.androidschool.core_network.data.dto.MoviesResponse

interface MovieApiInterface {

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String, @Query("language") language: String): Single<MoviesResponse>

    @GET("search/movie")
    fun searchByQuery(@Query("api_key") apiKey: String, @Query("language") language: String, @Query("query") query: String): Single<MoviesResponse>
}
