package com.aykuttasil.mymoviebook.ui.activity.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aykuttasil.mymoviebook.data.entity.Movie
import com.aykuttasil.mymoviebook.data.repository.MovieRepository
import com.aykuttasil.mymoviebook.ui.activity.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val app: Application,
    private val movieRepository: MovieRepository
) : BaseViewModel(app) {

    val liveMovies: MutableLiveData<List<Movie>> = MutableLiveData()

    val liveSnackbar: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        viewModelScope.launch {
            try {
                movieRepository.getPopularMovies(1).run {
                    liveMovies.value = this.results
                }
            } catch (ex: Exception) {
                liveSnackbar.value = ex.message ?: ex.toString()
            }
        }
    }

}