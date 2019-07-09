package com.aykuttasil.mymoviebook.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aykuttasil.mymoviebook.ui.activity.main.MainViewModel
import com.aykuttasil.mymoviebook.ui.fragment.nowplayingmovies.NowPlayingMoviesViewModel
import com.aykuttasil.mymoviebook.ui.fragment.popularmovies.PopularMoviesViewModel
import com.aykuttasil.mymoviebook.ui.fragment.upcomingmovies.UpcomingMoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelBuilder {

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainVieWModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(PopularMoviesViewModel::class)
    abstract fun providePopularMoviesViewModel(viewModel: PopularMoviesViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(UpcomingMoviesViewModel::class)
    abstract fun provideUpcomingMoviesViewModel(viewModel: UpcomingMoviesViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(NowPlayingMoviesViewModel::class)
    abstract fun provideNowPlayingMoviesViewModel(viewModel: NowPlayingMoviesViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
