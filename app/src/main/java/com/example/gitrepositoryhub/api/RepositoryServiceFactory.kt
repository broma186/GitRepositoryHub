package com.example.gitrepositoryhub.api

import com.example.gitrepositoryhub.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RepositoryServiceFactory {

    fun createRepositoryService(): RepositoryService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RepositoryService::class.java)
    }
}