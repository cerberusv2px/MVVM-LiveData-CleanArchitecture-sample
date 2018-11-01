package com.sujin.mvvmsamplearchitecture.data.remote.entity

import com.google.gson.annotations.SerializedName

data class PostsRemoteModel(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String,
    @SerializedName("userId") var userId: Int
)