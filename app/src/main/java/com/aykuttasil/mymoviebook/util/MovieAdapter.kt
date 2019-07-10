package com.aykuttasil.mymoviebook.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aykuttasil.mymoviebook.R
import com.aykuttasil.mymoviebook.data.entity.Movie
import com.aykuttasil.mymoviebook.databinding.ListitemMovieBinding
import com.aykuttasil.mymoviebook.ui.fragment.popularmovies.DataHolder
import timber.log.Timber

interface IMovieClickListener {
    fun movieClick(movie: Movie)
}

class MovieAdapter(private val listener: IMovieClickListener) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK),
    BindableAdapter<Movie> {

    override fun setData(items: DataHolder<List<Movie>>) {
        when (items) {
            is DataHolder.Success -> {
                Timber.d("setData(), items Count:${items.data.size}")
                submitList(items.data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding: ListitemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.listitem_movie,
            parent,
            false
        )
        return MovieViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieViewHolder(
        val binding: ListitemMovieBinding,
        private val listener: IMovieClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.root.setOnClickListener {
                listener.movieClick(movie)
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return true
            }
        }
    }

}
