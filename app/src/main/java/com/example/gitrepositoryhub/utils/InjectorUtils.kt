package com.example.gitrepositoryhub.utils

import android.content.Context
import com.example.gitrepositoryhub.data.AppDatabase
import com.example.gitrepositoryhub.data.RepositoryRepository
import com.example.gitrepositoryhub.viewmodels.RepositoriesViewModelFactory

object InjectorUtils {

    fun getRepositoryRepository(context: Context): RepositoryRepository {
        return RepositoryRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).repositoryDao())
    }

    fun provideRepositoriesViewModelFactory(
        context: Context
    ): RepositoriesViewModelFactory {
        val repository = getRepositoryRepository(context)
        return RepositoriesViewModelFactory(repository, context)
    }
}

