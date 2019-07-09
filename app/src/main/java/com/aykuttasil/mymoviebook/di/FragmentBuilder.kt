package com.aykuttasil.mymoviebook.di

import com.aykuttasil.mymoviebook.di.scopes.PerFragment
import com.aykuttasil.mymoviebook.ui.fragment.nowplayingmovies.NowPlayingMoviesFragment
import com.aykuttasil.mymoviebook.ui.fragment.popularmovies.PopularMoviesFragment
import com.aykuttasil.mymoviebook.ui.fragment.upcomingmovies.UpcomingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindPopularMoviesFragment(): PopularMoviesFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindUpcomingMoviesFragment(): UpcomingMoviesFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindNowPlayingMoviesFragment(): NowPlayingMoviesFragment

}
