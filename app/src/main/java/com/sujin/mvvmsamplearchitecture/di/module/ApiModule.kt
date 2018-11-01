package com.sujin.mvvmsamplearchitecture.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.sujin.mvvmsamplearchitecture.data.Environment
import com.sujin.mvvmsamplearchitecture.data.remote.ApiService
import com.sujin.mvvmsamplearchitecture.data.remote.Constants
import com.sujin.mvvmsamplearchitecture.data.remote.helper.ApiInterceptor
import com.sujin.mvvmsamplearchitecture.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule {

    @Provides
    @PerApplication
    fun provideGson(): Gson = GsonBuilder().setLenient().create()


    @Provides
    @PerApplication
    fun provideHttpLogginInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }


    @Provides
    @PerApplication
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, apiInterceptor: ApiInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(apiInterceptor)
                addInterceptor(httpLoggingInterceptor)
                connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                readTimeout(Constants.READ_TIME_OUT, TimeUnit.SECONDS)
            }
            .build()
    }

    @Provides
    @PerApplication
    fun provideApiService(okHttpClient: OkHttpClient, gson: Gson): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Environment.getServerUrl())
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(ApiService::class.java)
    }


}