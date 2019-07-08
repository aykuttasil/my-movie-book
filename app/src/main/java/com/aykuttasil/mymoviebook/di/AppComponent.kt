package com.aykuttasil.mymoviebook.di

import android.app.Application
import com.aykuttasil.mymoviebook.App
import com.aykuttasil.mymoviebook.di.modules.AppModule
import com.aykuttasil.mymoviebook.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (ActivityBuilder::class),
        (NetworkModule::class)
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}