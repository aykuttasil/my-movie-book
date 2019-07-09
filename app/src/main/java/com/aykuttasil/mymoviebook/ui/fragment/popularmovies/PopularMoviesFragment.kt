package com.aykuttasil.mymoviebook.ui.fragment.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.aykuttasil.mymoviebook.R
import com.aykuttasil.mymoviebook.databinding.FragmentPopularmoviesBinding
import com.aykuttasil.mymoviebook.di.ViewModelFactory
import com.aykuttasil.mymoviebook.ui.fragment.BaseFragment
import javax.inject.Inject

class PopularMoviesFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel by viewModels<PopularMoviesViewModel> { viewModelFactory }

    lateinit var binding: FragmentPopularmoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_popularmovies, container, false)
        return binding.root
    }
}