package com.aykuttasil.mymoviebook.data.repository

import com.aykuttasil.mymoviebook.data.entity.User
import com.aykuttasil.mymoviebook.data.remote.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getUsers(): List<User> {
        return apiService.getUser()
    }
}