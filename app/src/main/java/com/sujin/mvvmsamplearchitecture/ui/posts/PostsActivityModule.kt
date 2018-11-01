package com.sujin.mvvmsamplearchitecture.ui.posts

import com.sujin.mvvmsamplearchitecture.di.scope.PerActivity
import com.sujin.mvvmsamplearchitecture.domain.repository.PostsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PostsActivityModule {

    @Provides
    @PerActivity
    fun providePostsViewModelFactory(
        postsRepository: PostsRepositoryImpl
    ): PostsViewModelFactory {
        return PostsViewModelFactory(postsRepository)
    }
}