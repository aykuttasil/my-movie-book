package com.aykuttasil.mymoviebook.ui.dialog

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.aykuttasil.mymoviebook.data.entity.Movie
import com.aykuttasil.mymoviebook.ui.BaseViewModel
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    val app: Application
) : BaseViewModel(app) {

    val liveMovie: MutableLiveData<Movie> = MutableLiveData()

    fun setMovie(movie: Movie) {
        liveMovie.value = movie
    }

}