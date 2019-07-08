package com.aykuttasil.mymoviebook.data.remote

import androidx.lifecycle.LiveData
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getUser(): LiveData<ApiResponse<String>>

}
