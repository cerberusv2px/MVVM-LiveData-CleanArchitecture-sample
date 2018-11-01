package com.sujin.mvvmsamplearchitecture.domain.repository

import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel
import com.sujin.mvvmsamplearchitecture.data.mapper.PostsMapper
import com.sujin.mvvmsamplearchitecture.data.remote.entity.PostsRemoteModel
import com.sujin.mvvmsamplearchitecture.utils.SchedulersFactory
import io.reactivex.Observable
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val schedulersFactory: SchedulersFactory,
    private val postLocalRepo: PostsRepository.Local,
    private val postRemoteRepo: PostsRepository.Remote
) : PostsRepository.Local, PostsRepository.Remote {

    override fun insertPosts(posts: List<PostsDiskModel>) {
        postLocalRepo.insertPosts(posts)
    }

    override fun fetchPosts(): Observable<List<PostsRemoteModel>> {
        return postRemoteRepo.fetchPosts()
            .doOnNext { posts ->
                insertPosts(posts.map {
                    PostsMapper.mapToLocal(it)
                })
            }
            .subscribeOn(schedulersFactory.io())
            .observeOn(schedulersFactory.ui())
    }
}