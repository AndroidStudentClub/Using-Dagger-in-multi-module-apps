package ru.androidschool.intensiv.data.repository

import io.reactivex.Single
import ru.androidschool.core_network.data.dto.Movie
import ru.androidschool.core_network.di.MovieApiInterface
import ru.androidschool.intensiv.domain.MoviesRepository

class PopularMoviesRepository(private val api: MovieApiInterface) : MoviesRepository {

    override fun getMovies(): Single<List<Movie>> {
        return api.getTopRatedMovies(apiKey = "API KEY", language = "ru")
            .map { it.results }
    }
}
