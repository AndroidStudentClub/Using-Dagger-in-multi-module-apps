package ru.androidschool.intensiv.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.androidschool.intensiv.data.repository.PopularMoviesRepository

class FeedViewModelFactory(
    private val repository: PopularMoviesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FeedViewModel(repository) as T
    }

}