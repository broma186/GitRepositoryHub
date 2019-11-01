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

/*
Allows injection to the repositories activity so all subseqeuent dependencies can
 be injected. A scope is set for the activity so it's dependencies cab annotated to
 work in it's scope.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeRepositoriesActivity(): RepositoriesActivity
}
