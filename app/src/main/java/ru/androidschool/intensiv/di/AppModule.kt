package ru.androidschool.intensiv.di

import dagger.Module
import dagger.Provides
import ru.androidschool.core_network.di.MovieApiInterface
import ru.androidschool.intensiv.data.repository.PopularMoviesRepository

@Module
class AppModule {

    @Provides
    fun provideFeedRepository(api: MovieApiInterface): PopularMoviesRepository {
        return PopularMoviesRepository(api)
    }
}