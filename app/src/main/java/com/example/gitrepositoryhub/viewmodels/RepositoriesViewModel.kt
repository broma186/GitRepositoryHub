package com.example.gitrepositoryhub.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryRepository


class RepositoriesViewModel internal constructor(
    repositoryRepository: RepositoryRepository
) : ViewModel(), RepositoriesInterface {
    val productList: LiveData<List<Repository>> =
        getRepositoriesForDisplay(repositoryRepository)

    override fun getRepositoriesForDisplay(repositoryRepository: RepositoryRepository): LiveData<List<Repository>> {
        return repositoryRepository.getRepositories()
    }


    fun storeAllRepositories() {

    }
}


