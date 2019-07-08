package com.aykuttasil.mymoviebook.di

import com.aykuttasil.mymoviebook.di.scopes.PerActivity
import com.aykuttasil.mymoviebook.ui.activity.main.MainActivity
import com.aykuttasil.mymoviebook.ui.activity.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentBuilder::class])
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}
