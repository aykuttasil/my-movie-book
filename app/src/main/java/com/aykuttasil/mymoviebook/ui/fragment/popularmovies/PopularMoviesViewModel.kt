package com.aykuttasil.mymoviebook.ui.fragment.popularmovies

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aykuttasil.mymoviebook.data.entity.Movie
import com.aykuttasil.mymoviebook.data.repository.MovieRepository
import com.aykuttasil.mymoviebook.ui.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class DataHolder<T> {
    data class Success<T>(val data: T) : DataHolder<T>()
    data class Error<T>(val error: Throwable) : DataHolder<T>()
    class Loading<T> : DataHolder<T>()

    companion object {
        fun <T> success(data: T): DataHolder<T> {
            return Success(data)
        }

        fun <T> error(throwable: Throwable): DataHolder<T> {
            return Error(throwable)
        }
    }
}

class PopularMoviesViewModel @Inject constructor(
    val app: Application,
    private val movieRepository: MovieRepository
) : BaseViewModel(app) {

    data class Page(var currentPage: Int = 1, var totalPages: Int = 1)

    private val _popularTvShowsLiveData = MediatorLiveData<DataHolder<List<Movie>>>()
    val liveMovies: LiveData<DataHolder<List<Movie>>>
        get() = _popularTvShowsLiveData

    val liveSnackbar: MutableLiveData<String> = MutableLiveData()

    private val _listMovie = arrayListOf<Movie>()
    private val _pageLiveData = MutableLiveData<Int>()
    private val _page = Page()

    init {
        _popularTvShowsLiveData.addSource(_pageLiveData) {
            getPopularMovies(it)
        }
        getPopularMoviesByPagination()
    }

    fun getPopularMovies(pageNumber: Int) {
        _popularTvShowsLiveData.value = DataHolder.Loading()
        viewModelScope.launch {
            try {
                movieRepository.getPopularMovies(pageNumber).run {
                    _page.currentPage = this.page!!
                    _page.totalPages = this.totalPages!!

                    val movieList = this.results!!
                    _listMovie.addAll(movieList)

                    val newList = arrayListOf<Movie>().apply {
                        addAll(_listMovie)
                    }
                    _popularTvShowsLiveData.value = DataHolder.success(newList)
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                liveSnackbar.value = ex.message ?: ""
            }
        }
    }

    fun getPopularMoviesByPagination() {
        if (_pageLiveData.value == null) {
            _pageLiveData.value = _page.currentPage
        } else {
            val nextPage = _page.currentPage + 1
            if (nextPage > _page.totalPages) {
                return
            }
            _pageLiveData.value = nextPage
        }
    }
}