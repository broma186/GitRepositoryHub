package com.example.gitrepositoryhub.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitrepositoryhub.data.RepositoryRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoriesViewModelFactory @Inject
    constructor(val repository: RepositoryRepository,
                val context : Context
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepositoriesViewModel(repository, context) as T
    }
}
