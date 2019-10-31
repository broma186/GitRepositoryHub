package com.example.gitrepositoryhub.api

import com.example.gitrepositoryhub.data.Repository
import retrofit2.Response
import retrofit2.http.GET

interface RepositoryService {

    @GET("orgs/square/repos")
    fun getRepositories(): Response<List<Repository>>
}