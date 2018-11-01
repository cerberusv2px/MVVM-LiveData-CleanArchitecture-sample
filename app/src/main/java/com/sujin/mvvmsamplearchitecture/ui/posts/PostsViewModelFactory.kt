package com.sujin.mvvmsamplearchitecture.ui.posts

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepositoryImpl
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class PostsViewModelFactory @Inject constructor(
    private val postsRepository: PostsRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
            return PostsViewModel(postsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}