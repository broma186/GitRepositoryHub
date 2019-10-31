package com.example.gitrepositoryhub.data

import com.example.gitrepositoryhub.api.RepositoryService
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryDataRepository
@Inject
constructor(private val repositoryService: RepositoryService) : RepositoryRepository {

    override fun getRepositories(): Response<List<Repository>> {
        return repositoryService.getRepositories()
    }
}

