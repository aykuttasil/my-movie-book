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
package com.aykuttasil.mymoviebook.ui.fragment.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.aykuttasil.mymoviebook.data.entity.Movie
import com.aykuttasil.mymoviebook.databinding.FragmentPopularmoviesBinding
import com.aykuttasil.mymoviebook.di.ViewModelFactory
import com.aykuttasil.mymoviebook.ui.dialog.MovieDetailDialog
import com.aykuttasil.mymoviebook.ui.fragment.BaseFragment
import com.aykuttasil.mymoviebook.util.EndlessRecyclerOnScrollListener
import com.aykuttasil.mymoviebook.util.IMovieClickListener
import com.aykuttasil.mymoviebook.util.MovieAdapter
import com.aykuttasil.mymoviebook.util.displaySnackbar
import kotlinx.android.synthetic.main.fragment_popularmovies.*
import timber.log.Timber
import javax.inject.Inject

class PopularMoviesFragment : BaseFragment(), IMovieClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val _viewModel by activityViewModels<PopularMoviesViewModel> { viewModelFactory }

    lateinit var binding: FragmentPopularmoviesBinding

    private val movieListAdapter = MovieAdapter(this)

    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularmoviesBinding.inflate(inflater).apply {
            lifecycleOwner = this@PopularMoviesFragment
            viewModel = _viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _viewModel.liveSnackbar.observe(this, Observer {
            requireView().displaySnackbar(it)
        })
    }

    private fun setListView() {
        listMovie.addOnScrollListener(recyclerViewOnScrollListener)
        listMovie.adapter = movieListAdapter
    }

    private val recyclerViewOnScrollListener = object : EndlessRecyclerOnScrollListener() {
        override fun onLoadMore() {
            Timber.d("onLoadMore")
            _viewModel.getPopularMoviesByPagination()
        }
    }

    override fun movieClick(movie: Movie) {
        Timber.d(movie.title)
        val dialog = MovieDetailDialog(movie)
        dialog.show(childFragmentManager, "movie_detail")
    }
}
