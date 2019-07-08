package com.aykuttasil.mymoviebook.data.remote

import com.aykuttasil.mymoviebook.data.entity.User
import com.aykuttasil.mymoviebook.data.remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUser(): List<User>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1
    ): MovieResponse

}