package com.sujin.mvvmsamplearchitecture.data.local

object Constants {

    const val APP_NAME = "MVVM"

    /**
     * SharedPreference keystore
     */
    const val PREF_FILE = "mvvmsample"
    const val PREF_TOKEN = "access_token"
    const val PREF_REFRESH_TOKEN = "refresh_token"

    /**
     * Database name
     */
    const val DB_NAME = "mvvm.db"

    /**
     * Database table
     */
    const val TBL_POST = "posts"


    //Posts
    const val POST_ID = "id"
    const val POST_TITLE = "title"
    const val POST_BODY = "body"
    const val POST_USER_ID = "user_id"
}