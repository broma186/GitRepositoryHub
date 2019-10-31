package com.example.gitrepositoryhub.di.module

import com.example.gitrepositoryhub.api.RepositoryService
import com.example.gitrepositoryhub.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): RepositoryService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RepositoryService::class.java)
    }

}
