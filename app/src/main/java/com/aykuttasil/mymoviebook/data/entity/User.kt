package com.aykuttasil.mymoviebook.data.entity

import com.google.gson.annotations.Expose

data class User(
    @Expose var id: String? = null,
    @Expose var name: String? = null,
    @Expose var avatar: String? = null,
    @Expose var createdAt: String? = null
)