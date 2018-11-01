package com.sujin.mvvmsamplearchitecture.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.sujin.mvvmsamplearchitecture.data.local.dao.PostDao

import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel

@Database(
    entities = [
        (PostsDiskModel::class)
    ], version = 1
)
abstract class MVVMDatabase : RoomDatabase() {

    companion object {
        var instance: MVVMDatabase? = null
        fun getInstance(context: Context): MVVMDatabase {
            if (instance == null) {
                instance = createInstance(context)
            }
            return instance as MVVMDatabase
        }

        private fun createInstance(context: Context): MVVMDatabase {
            return Room.databaseBuilder(context, MVVMDatabase::class.java, Constants.DB_NAME)
                .build()
        }
    }

    abstract fun getPostsDao(): PostDao
}