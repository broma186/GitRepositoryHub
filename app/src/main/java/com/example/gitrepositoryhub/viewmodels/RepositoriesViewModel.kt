package com.example.gitrepositoryhub.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/*
The ViewModel class for the repositories activity that provides the livedata needed to be observed to
 update the relevant recycler view adapter. Downloads (and stores once Room is implemented) repositories
 when the ViewModel is created.
 */
class RepositoriesViewModel @Inject constructor(val repositoryRepository: RepositoryRepository) : ViewModel() {

    val repositoryLiveData = MutableLiveData<List<Repository>>()

    init {
        storeAllRepositories()
    }
        /*
     Coroutine runs on the IO thread for the API call to the endpoint that retrieves all repositories
     with a GET request. If successful the results are stored in the database. Toast error reporting
     will display on the main thread should either of the product operations fail.
      */
    fun storeAllRepositories() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<List<Repository>> = repositoryRepository.getRepositories()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    repositoryLiveData.value = response.body()
                }
            }
        }
    }
}


