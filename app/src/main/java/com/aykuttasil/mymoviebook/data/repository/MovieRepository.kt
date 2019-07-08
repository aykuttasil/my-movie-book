package com.aykuttasil.mymoviebook.data.repository

import com.aykuttasil.mymoviebook.data.remote.ApiService
import com.aykuttasil.mymoviebook.data.remote.model.MovieResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPopularMovies(page: Int): MovieResponse {
        return apiService.getPopularMovies(page)
    }
}