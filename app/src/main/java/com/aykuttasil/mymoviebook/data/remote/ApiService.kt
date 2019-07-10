package com.aykuttasil.mymoviebook.data.remote

import com.aykuttasil.mymoviebook.data.entity.Movie
import com.aykuttasil.mymoviebook.data.remote.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1
    ): MovieListResponse

    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") movieId: Int
    ): Movie

}