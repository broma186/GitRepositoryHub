package com.example.gitrepositoryhub.api

import android.content.Context
import com.example.gitrepositoryhub.data.AppDatabase
import com.example.gitrepositoryhub.data.Repository
import retrofit2.Response

object RepositoryServiceUtilities {

    // Gets all the products from the server endpoint.
    suspend fun getRepositories() : Response<List<Repository>> = RepositoryServiceFactory.
        createRepositoryService().getRepositories()

    /* Gets the Room database Dao class and calls the insertAll method that adds all the downloaded
        repositories to the db.
    */
    suspend fun writeRepositoriesToDb(repositories: List<Repository>?, context: Context) =
        AppDatabase.getInstance(context).repositoryDao().insertAll(repositories)
}