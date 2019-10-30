package com.example.gitrepositoryhub.data

// The repository of the repository of all repositorie's repositories.
class RepositoryRepository private constructor(
    private val repositoryDao: RepositoryDao
) {

    fun getRepositories() = repositoryDao.getRepositories()

    companion object {
        @Volatile private var instance: RepositoryRepository? = null
        fun getInstance(repositoryDao: RepositoryDao) =
            instance ?: synchronized(this) {
                instance ?: RepositoryRepository(repositoryDao).also { instance = it }
            }
    }

}