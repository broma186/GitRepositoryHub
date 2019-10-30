package com.example.gitrepositoryhub.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitrepositoryhub.di.ViewModelKey
import com.example.gitrepositoryhub.viewmodels.RepositoriesViewModel
import com.example.gitrepositoryhub.viewmodels.RepositoriesViewModelFactory
import dagger.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(RepositoriesViewModel::class)
    abstract fun bindMainViewModel(repositoriesViewModel: RepositoriesViewModel): ViewModel

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScope
        fun bindViewModelFactory(repositoriesViewModelFactory: RepositoriesViewModelFactory): ViewModelProvider.NewInstanceFactory {
            return repositoriesViewModelFactory
        }
    }
}
