package ru.androidschool.intensiv.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.androidschool.core_network.data.dto.Movie
import ru.androidschool.intensiv.data.repository.PopularMoviesRepository
import timber.log.Timber
import javax.inject.Inject

class FeedViewModel @Inject constructor(repository: PopularMoviesRepository) : ViewModel() {

    private val _data = MutableLiveData<List<Movie>>()
    val data: LiveData<List<Movie>> = _data

    private val compositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(
            repository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _data.value = it
                }, {
                    Timber.e("FeedFragment", it.toString())
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

