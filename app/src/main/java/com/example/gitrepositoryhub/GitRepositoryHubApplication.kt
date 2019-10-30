package com.example.gitrepositoryhub

import android.app.Application
import android.content.Context
import com.example.gitrepositoryhub.api.RepositoryServiceUtilities
import com.example.gitrepositoryhub.data.Repository
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast
import retrofit2.Response
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