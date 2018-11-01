package com.sujin.mvvmsamplearchitecture.di.component

import android.app.Application
import com.sujin.mvvmsamplearchitecture.MVVMApplication
import com.sujin.mvvmsamplearchitecture.di.module.ApplicationModule
import com.sujin.mvvmsamplearchitecture.di.provider.ActivityBindingModule
import com.sujin.mvvmsamplearchitecture.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [
    (ActivityBindingModule::class),
    (ApplicationModule::class),
    (AndroidSupportInjectionModule::class)
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MVVMApplication)
}