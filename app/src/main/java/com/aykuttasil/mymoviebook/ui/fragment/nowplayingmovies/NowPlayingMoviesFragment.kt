package com.aykuttasil.mymoviebook.ui.fragment.nowplayingmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.aykuttasil.mymoviebook.R
import com.aykuttasil.mymoviebook.databinding.FragmentNowplayingmoviesBinding
import com.aykuttasil.mymoviebook.di.ViewModelFactory
import com.aykuttasil.mymoviebook.ui.fragment.BaseFragment
import com.aykuttasil.mymoviebook.ui.fragment.popularmovies.PopularMoviesViewModel
import javax.inject.Inject

class NowPlayingMoviesFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel by viewModels<PopularMoviesViewModel> { viewModelFactory }

    lateinit var binding: FragmentNowplayingmoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_nowplayingmovies, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}