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

import com.aykuttasil.mymoviebook.di.scopes.PerFragment
import com.aykuttasil.mymoviebook.ui.dialog.MovieDetailDialog
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

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindMovieDetailDialog(): MovieDetailDialog
}
