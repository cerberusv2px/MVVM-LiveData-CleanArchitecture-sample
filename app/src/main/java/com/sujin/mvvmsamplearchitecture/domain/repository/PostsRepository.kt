package com.sujin.mvvmsamplearchitecture.domain.repository

import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel
import com.sujin.mvvmsamplearchitecture.data.remote.entity.PostsRemoteModel
import io.reactivex.Observable

interface PostsRepository {

    interface Local {
        fun insertPosts(posts: List<PostsDiskModel>)
    }


    interface Remote {
        fun fetchPosts(): Observable<List<PostsRemoteModel>>
    }
}