package com.sujin.mvvmsamplearchitecture.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<PostsDiskModel>)

    @Query("SELECT * FROM posts")
    fun getAll(): LiveData<List<PostsDiskModel>>
}