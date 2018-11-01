package com.sujin.mvvmsamplearchitecture.di.module

import com.sujin.mvvmsamplearchitecture.data.local.DatabaseManager
import com.sujin.mvvmsamplearchitecture.data.local.SharedPreferenceManager
import com.sujin.mvvmsamplearchitecture.data.local.impl.PostsRepositoryLocalImpl
import com.sujin.mvvmsamplearchitecture.data.remote.ApiService
import com.sujin.mvvmsamplearchitecture.data.remote.impl.PostsRemoteImpl
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepository
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepositoryImpl
import com.sujin.mvvmsamplearchitecture.utils.SchedulersFactory
import dagger.Module
import dagger.Provides

@Module
class PostsModule {

    @Provides
    fun providePostsLocal(
        sharedPreferenceManager: SharedPreferenceManager,
        databaseManager: DatabaseManager
    ): PostsRepository.Local {
        return PostsRepositoryLocalImpl(sharedPreferenceManager, databaseManager)
    }

    @Provides
    fun providePostsRemote(
        apiService: ApiService
    ): PostsRepository.Remote {
        return PostsRemoteImpl(apiService)
    }

    @Provides
    fun providePostsRepository(
        schedulersFactory: SchedulersFactory,
        postsLocal: PostsRepository.Local,
        postsRemote: PostsRepository.Remote
    ): PostsRepositoryImpl {
        return PostsRepositoryImpl(schedulersFactory, postsLocal, postsRemote)
    }
}