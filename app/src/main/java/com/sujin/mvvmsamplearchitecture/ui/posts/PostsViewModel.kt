package com.sujin.mvvmsamplearchitecture.ui.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel
import com.sujin.mvvmsamplearchitecture.data.mapper.PostsMapper
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepositoryImpl
import com.sujin.mvvmsamplearchitecture.utils.viewmodel.Response
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val postsRepositoryImpl: PostsRepositoryImpl
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val fetchPostsListUseCase = MutableLiveData<Response<List<PostsDiskModel>>>()

    fun postsResponse(): MutableLiveData<Response<List<PostsDiskModel>>> = fetchPostsListUseCase

    fun fetchPostsList() {
        disposables.add(
            postsRepositoryImpl.fetchPosts()
                .doOnSubscribe {
                    fetchPostsListUseCase.value = Response.loading()
                }
                .subscribe({
                    fetchPostsListUseCase.value =
                            Response.complete(it.map { PostsMapper.mapToLocal(it) })
                }, {
                    fetchPostsListUseCase.value = Response.error(it)
                })
        )
    }
}