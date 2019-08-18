/**
 * Designed and developed by Aykut Asil (@aykuttasil)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aykuttasil.mymoviebook.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aykuttasil.mymoviebook.ui.activity.main.MainViewModel
import com.aykuttasil.mymoviebook.ui.dialog.MovieDetailViewModel
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

    @IntoMap
    @Binds
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun provideMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
