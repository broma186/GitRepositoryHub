package com.example.gitrepositoryhub.data

import android.content.Context
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

// The repository of the repository of all repositorie's repositories.
interface RepositoryRepository {

    // Downloads all the products from the server endpoint.
    suspend fun getRepositories() : Response<List<Repository>>
}