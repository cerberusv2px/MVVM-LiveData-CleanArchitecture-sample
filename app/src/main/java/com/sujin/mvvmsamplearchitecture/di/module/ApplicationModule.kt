package com.sujin.mvvmsamplearchitecture.di.module

import android.app.Application
import android.content.Context
import com.sujin.mvvmsamplearchitecture.data.local.DatabaseManager
import com.sujin.mvvmsamplearchitecture.data.local.SharedPreferenceManager
import com.sujin.mvvmsamplearchitecture.di.scope.PerApplication
import com.sujin.mvvmsamplearchitecture.utils.SchedulersFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module(includes = [
    ApiModule::class
])
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    fun provideScheduler() = object : SchedulersFactory {
        override fun ui(): Scheduler = AndroidSchedulers.mainThread()
        override fun io(): Scheduler = Schedulers.io()
    }

    @Provides
    @PerApplication
    fun provideSharedPreference(context: Context): SharedPreferenceManager {
        return SharedPreferenceManager(context)
    }

    @Provides
    @PerApplication
    fun provideDatabaseManager(context: Context): DatabaseManager {
        return DatabaseManager(context)
    }
}