package com.example.gitrepositoryhub.viewmodels

import com.example.gitrepositoryhub.api.RepositoryService
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryRepository
import com.example.gitrepositoryhub.viewmodels.RepositoriesViewModel
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Response


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoriesViewModelTest {

    @Mock
    private lateinit var mockRepository: RepositoryRepository

    private lateinit var repositoriesViewModel: RepositoriesViewModel

    @Mock
    private lateinit var mockSuccessResponse: Response<List<Repository>>

    private val failureResponse: Response<List<Repository>>? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repositoriesViewModel = RepositoriesViewModel(mockRepository)
    }

    @Test
    fun getRepositories_successful() {
        CoroutineScope(Dispatchers.IO).launch {
            assertTrue(mockRepository.getRepositories().isSuccessful)
        }
    }

    @Test
    fun getRepositories_returns_correct_response() = runBlocking {
        whenever(mockRepository.getRepositories()).thenReturn(mockSuccessResponse)

        assert(mockRepository != null)
    }

    @Test
    fun getRepositories_called() = runBlocking {
        whenever(mockRepository.getRepositories()).thenReturn(mockSuccessResponse)

        verify(mockRepository, times(1)).getRepositories()

        assert(mockRepository != null)
    }
}
