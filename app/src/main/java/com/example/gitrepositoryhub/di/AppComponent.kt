package di

import com.example.gitrepositoryhub.GitRepositoryHubApplication
import com.example.gitrepositoryhub.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
All the dagger modules needed for DI.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<GitRepositoryHubApplication>

