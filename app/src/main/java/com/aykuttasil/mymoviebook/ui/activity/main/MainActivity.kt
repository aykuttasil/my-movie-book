package com.aykuttasil.mymoviebook.ui.activity.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.aykuttasil.mymoviebook.R
import com.aykuttasil.mymoviebook.di.ViewModelFactory
import com.aykuttasil.mymoviebook.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupWithNavController(
            bottomNavigationView,
            findNavController(R.id.fragmentHost)
        )

        NavigationUI.setupWithNavController(toolbar, findNavController(R.id.fragmentHost))

        /*
        viewModel.liveMovies.observe(this, Observer { movieList ->
            movieList.forEach { movie ->
                println(movie.title)
            }
        })

        viewModel.liveSnackbar.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        viewModel.getPopularMovies()

         */
    }
}
