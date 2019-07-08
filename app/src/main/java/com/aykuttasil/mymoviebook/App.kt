package com.aykuttasil.mymoviebook

import com.aykuttasil.mymoviebook.di.DaggerAppComponent
import com.aykuttasil.mymoviebook.util.debug
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        debug {
            Timber.plant(Timber.DebugTree())
        }
    }
}