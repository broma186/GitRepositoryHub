package com.example.gitrepositoryhub.data

import com.example.gitrepositoryhub.api.RepositoryService
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/*
The class that calls the injected service as a dependency to download the git repositories
from the server.
 */
@Singleton
class RepositoryDataRepository
@Inject
constructor(private val repositoryService: RepositoryService) : RepositoryRepository {

    override suspend fun getRepositories(): Response<List<Repository>> {
        return repositoryService.getRepositories()
    }
}

