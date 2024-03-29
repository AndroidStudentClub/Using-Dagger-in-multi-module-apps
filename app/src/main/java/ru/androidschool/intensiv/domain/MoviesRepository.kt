package ru.androidschool.intensiv.domain

import io.reactivex.Single
import ru.androidschool.core_network.data.dto.Movie

interface MoviesRepository {

    fun getMovies(): Single<List<Movie>>

}