package com.sujin.mvvmsamplearchitecture.di.provider

import com.sujin.mvvmsamplearchitecture.di.scope.PerActivity
import com.sujin.mvvmsamplearchitecture.ui.posts.PostsActivity
import com.sujin.mvvmsamplearchitecture.ui.posts.PostsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    /*@PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (MainActivityBindingModule::class)])
    abstract fun bindMainActivity(): MainActivity*/

    @PerActivity
    @ContributesAndroidInjector(modules = [(PostsActivityModule::class)])
    abstract fun bindPostsActivity(): PostsActivity
}