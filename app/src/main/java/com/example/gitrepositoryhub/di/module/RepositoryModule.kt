package com.example.gitrepositoryhub.di.module

import com.example.gitrepositoryhub.api.RepositoryService
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryDao
import com.example.gitrepositoryhub.data.RepositoryDataRepository
import com.example.gitrepositoryhub.data.RepositoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepositoryRepository(repositoryDataRepository: RepositoryDataRepository): RepositoryRepository

}