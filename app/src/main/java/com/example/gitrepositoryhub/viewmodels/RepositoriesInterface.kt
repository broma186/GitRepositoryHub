package com.example.gitrepositoryhub.viewmodels

import androidx.lifecycle.LiveData
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryRepository

interface RepositoriesInterface {
    fun getRepositoriesForDisplay(repositoryRepository: RepositoryRepository) : LiveData<List<Repository>>
}