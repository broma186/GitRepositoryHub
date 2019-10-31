package dagger

import com.example.gitrepositoryhub.GitRepositoryHubApplication
import com.example.gitrepositoryhub.di.module.RepositoryBindingModule
import com.example.gitrepositoryhub.di.module.RepositoryModule
import com.example.gitrepositoryhub.di.module.ViewModelModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        RepositoryBindingModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<GitRepositoryHubApplication>

