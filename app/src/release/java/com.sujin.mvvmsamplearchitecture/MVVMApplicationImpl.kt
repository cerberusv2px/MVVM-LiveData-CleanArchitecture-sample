package com.sujin.mvvmsamplearchitecture

import com.facebook.stetho.Stetho

class MVVMApplicationImpl: MVVMApplication() {

    override fun initConfig() {
        initializeStetho()
    }

    private fun initializeStetho() {
        val builder = Stetho.newInitializerBuilder(this)
        builder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        builder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        Stetho.initialize(builder.build())
    }
}
