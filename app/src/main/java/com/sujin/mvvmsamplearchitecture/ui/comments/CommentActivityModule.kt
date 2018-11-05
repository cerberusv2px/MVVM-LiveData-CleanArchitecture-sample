package com.sujin.mvvmsamplearchitecture.ui.comments

import android.app.Application
import com.sujin.mvvmsamplearchitecture.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class CommentActivityModule {

    @Provides
    @PerActivity
    fun provideCommentViewModelFactory(
        application: Application
    ): CommentViewModelFactory {
        return CommentViewModelFactory(application)
    }
}