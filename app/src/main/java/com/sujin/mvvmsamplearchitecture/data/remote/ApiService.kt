package com.sujin.mvvmsamplearchitecture.data.remote


import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun fetchPost(): Observable<List<String>>
}