package com.sujin.mvvmsamplearchitecture.data.mapper

import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel
import com.sujin.mvvmsamplearchitecture.data.remote.entity.PostsRemoteModel

object PostsMapper: Mapper<PostsDiskModel, PostsRemoteModel> {

    override fun mapFromLocal(type: PostsDiskModel): PostsRemoteModel {
        return PostsRemoteModel(type.id, type.title, type.body, type.userId)
    }

    override fun mapToLocal(type: PostsRemoteModel): PostsDiskModel {
        return PostsDiskModel(type.id, type.title, type.body, type.userId)
    }
}