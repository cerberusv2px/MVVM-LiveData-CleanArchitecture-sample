package com.sujin.mvvmsamplearchitecture.data.remote.impl

import com.sujin.mvvmsamplearchitecture.data.remote.ApiService
import com.sujin.mvvmsamplearchitecture.data.remote.entity.PostsRemoteModel
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * use notnullmapper w.r.t BaseResponse of API
 */

class PostsRemoteImpl @Inject constructor(val apiService: ApiService) : PostsRepository.Remote {

    override fun fetchPosts(): Observable<List<PostsRemoteModel>> {
        return apiService.fetchPost()
            //.flatMap(NotNullMapper())
    }
}