package com.example.gitrepositoryhub

import android.app.Application
import android.content.Context
import com.example.gitrepositoryhub.api.RepositoryServiceUtilities
import com.example.gitrepositoryhub.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast
import retrofit2.Response

class GitRepositoryHubApplication : Application(){

    val context : Context = this

    override fun onCreate() {
        super.onCreate()

    }

}