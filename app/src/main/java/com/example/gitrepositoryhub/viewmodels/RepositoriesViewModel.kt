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
import java.io.IOException
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
 with a GET request. If successful the results are assigned to the live data instance.
  */
    fun storeAllRepositories() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<List<Repository>> = repositoryRepository.getRepositories()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    repositoryLiveData.value = response.body()
                } else {
                    throw IOException("Failed to download repositories")
                }
            }
        }
    }
}


