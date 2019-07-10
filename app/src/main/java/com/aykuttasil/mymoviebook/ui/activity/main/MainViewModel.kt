package com.aykuttasil.mymoviebook.ui.activity.main

import android.app.Application
import com.aykuttasil.mymoviebook.data.repository.MovieRepository
import com.aykuttasil.mymoviebook.ui.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val app: Application,
    private val movieRepository: MovieRepository
) : BaseViewModel(app) {

}