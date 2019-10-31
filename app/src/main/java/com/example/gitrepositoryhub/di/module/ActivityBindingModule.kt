package com.example.gitrepositoryhub.di.module

import android.content.Context
import com.example.gitrepositoryhub.RepositoriesActivity
import com.example.gitrepositoryhub.data.RepositoryDao
import com.example.gitrepositoryhub.data.RepositoryRepository
import dagger.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeRepositoriesActivity(): RepositoriesActivity
}
