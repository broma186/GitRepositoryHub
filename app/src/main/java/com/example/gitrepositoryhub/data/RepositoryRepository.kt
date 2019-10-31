package com.example.gitrepositoryhub.data

import android.content.Context
import com.example.gitrepositoryhub.api.RepositoryServiceFactory
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

// The repository of the repository of all repositorie's repositories.
@Singleton
class RepositoryRepository @Inject internal constructor(
    val repositoryDao: RepositoryDao
) {

    // Get already stored repositories from room db.
    fun getRepositories() = repositoryDao.getRepositories()

    // Downloads all the products from the server endpoint.
    suspend fun downloadRepositories() : Response<List<Repository>> = RepositoryServiceFactory.
        createRepositoryService().getRepositories()

    /* Gets the Room database Dao class and calls the insertAll method that adds all the downloaded
        repositories to the db.
    */
    suspend fun writeRepositoriesToDb(repositories: List<Repository>?) =
        repositoryDao.insertAll(repositories)

    companion object {
        @Volatile private var instance: RepositoryRepository? = null
        fun getInstance(repositoryDao: RepositoryDao) =
            instance ?: synchronized(this) {
                instance ?: RepositoryRepository(repositoryDao).also { instance = it }
            }
    }

}