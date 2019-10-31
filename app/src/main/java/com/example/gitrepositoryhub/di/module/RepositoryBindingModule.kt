package com.example.gitrepositoryhub.di.module

import android.content.Context
import com.example.gitrepositoryhub.RepositoriesActivity
import com.example.gitrepositoryhub.data.RepositoryRepository
import com.example.redditsampler.PostsActivity
import com.example.redditsampler.adapters.PostAdapter
import dagger.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class RepositoryBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeRepositoriesActivity(): RepositoriesActivity

    @Binds
    abstract fun bindRepository(repository: RepositoryRepository): RepositoryRepository
}
