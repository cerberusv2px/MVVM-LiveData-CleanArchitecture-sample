package com.sujin.mvvmsamplearchitecture.data.local.impl

import com.sujin.mvvmsamplearchitecture.data.local.DatabaseManager
import com.sujin.mvvmsamplearchitecture.data.local.SharedPreferenceManager
import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryLocalImpl @Inject constructor(
    private val preferenceManager: SharedPreferenceManager,
    private val databaseManager: DatabaseManager
): PostsRepository.Local{

    val postDao = databaseManager.instance.getPostsDao()

    override fun insertPosts(posts: List<PostsDiskModel>) {
        postDao.insert(posts)
    }
}