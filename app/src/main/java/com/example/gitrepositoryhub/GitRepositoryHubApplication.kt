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
        storeAllRepositories()


    }
    /*
      Coroutine runs on the IO thread for the API call to the endpoint that retrieves all repositories
      with a GET request. If successful the results are stored in the database. Toast error reporting
      will display on the main thread should either of the product operations fail.
       */
    fun storeAllRepositories() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<List<Repository>> = RepositoryServiceUtilities.getRepositories()
            if (response.isSuccessful) {
                RepositoryServiceUtilities.writeRepositoriesToDb(response.body(), context)
            }
            withContext(Dispatchers.Main) {
                //setupRepositoriesList()
                if (!response.isSuccessful) {
                    toast("Failed to obtain repositories!")
                }
            }
        }
    }
}