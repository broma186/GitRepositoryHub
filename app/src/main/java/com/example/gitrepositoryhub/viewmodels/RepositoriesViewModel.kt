package com.example.gitrepositoryhub.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gitrepositoryhub.api.RepositoryServiceUtilities
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast
import retrofit2.Response


class RepositoriesViewModel internal constructor(
    repositoryRepository: RepositoryRepository, val context: Context
) : ViewModel(), RepositoriesInterface {
    val repositories: LiveData<List<Repository>> =
        getRepositoriesForDisplay(repositoryRepository)

    override fun getRepositoriesForDisplay(repositoryRepository: RepositoryRepository): LiveData<List<Repository>> {
        return repositoryRepository.getRepositories()
    }

    /*
     Coroutine runs on the IO thread for the API call to the endpoint that retrieves all repositories
     with a GET request. If successful the results are stored in the database. Toast error reporting
     will display on the main thread should either of the product operations fail.
      */
    fun storeAllRepositories() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<List<Repository>> = RepositoryServiceUtilities.getRepositories()
            if (response.isSuccessful) {
                RepositoryServiceUtilities.writeRepositoriesToDb(response.body(), context)
            }
        }
    }
}


