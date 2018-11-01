package com.sujin.mvvmsamplearchitecture.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.sujin.mvvmsamplearchitecture.data.local.Constants

@Entity(tableName = Constants.TBL_POST)
data class PostsDiskModel(
    @PrimaryKey @ColumnInfo(name = Constants.POST_ID) var id: Int,
    @ColumnInfo(name = Constants.POST_TITLE) var title: String,
    @ColumnInfo(name = Constants.POST_BODY) var body: String,
    @ColumnInfo(name = Constants.POST_USER_ID) var userId: Int
)