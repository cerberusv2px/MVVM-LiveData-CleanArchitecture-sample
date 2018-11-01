package com.sujin.mvvmsamplearchitecture.data.local

import android.content.Context
import com.sujin.mvvmsamplearchitecture.data.local.dao.PostDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseManager @Inject constructor(context: Context) {

    val instance = MVVMDatabase.getInstance(context)

    fun getPostDao(): PostDao = instance.getPostsDao()
}