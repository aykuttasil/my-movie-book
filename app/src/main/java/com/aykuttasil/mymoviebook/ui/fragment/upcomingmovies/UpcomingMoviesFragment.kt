package com.aykuttasil.mymoviebook.ui.fragment.upcomingmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.aykuttasil.mymoviebook.R
import com.aykuttasil.mymoviebook.databinding.FragmentUpcomingmoviesBinding
import com.aykuttasil.mymoviebook.di.ViewModelFactory
import com.aykuttasil.mymoviebook.ui.fragment.BaseFragment
import com.aykuttasil.mymoviebook.ui.fragment.popularmovies.PopularMoviesViewModel
import javax.inject.Inject

class UpcomingMoviesFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel by viewModels<PopularMoviesViewModel> { viewModelFactory }

    lateinit var binding: FragmentUpcomingmoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_upcomingmovies, container, false)
        return binding.root
    }
}