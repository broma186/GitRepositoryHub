package com.example.gitrepositoryhub

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class GitRepositoryHubApplication : Application(), HasAndroidInjector  {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    val context : Context = this

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.create().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector;
    }
}