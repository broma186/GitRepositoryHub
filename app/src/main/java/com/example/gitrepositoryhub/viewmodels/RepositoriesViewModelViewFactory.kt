package com.example.gitrepositoryhub.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitrepositoryhub.data.RepositoryRepository


class RepositoriesViewModelFactory(
    private val repository: RepositoryRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepositoriesViewModel(repository) as T
    }
}
