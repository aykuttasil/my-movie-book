package com.aykuttasil.mymoviebook.di.modules

import android.app.Application
import android.content.Context
import com.aykuttasil.mymoviebook.App
import com.aykuttasil.mymoviebook.di.ApplicationContext
import com.aykuttasil.mymoviebook.di.ViewModelBuilder

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(ViewModelBuilder::class)])
class AppModule {

    @Singleton
    @Provides
    @ApplicationContext
    internal fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideApp(application: Application): App {
        return application.applicationContext as App
    }
}
