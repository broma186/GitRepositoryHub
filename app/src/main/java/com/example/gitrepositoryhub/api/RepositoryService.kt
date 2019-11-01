package com.example.gitrepositoryhub.api

import com.example.gitrepositoryhub.data.Repository
import retrofit2.Response
import retrofit2.http.GET

/*
    The GET request to retrieve the repositories from the server.
    Is a suspend function so that the call can be suspended if async call
    is eventually used. The response is a list of Repository POJO which can
    be switched to RoomRepository when Room is implemented (when necessary).
    Is a dependency of the injected RepositoryDataRepository and provided by the
    Network module.
 */
interface RepositoryService {

    @GET("orgs/square/repos")
    suspend fun getRepositories(): Response<List<Repository>>
}