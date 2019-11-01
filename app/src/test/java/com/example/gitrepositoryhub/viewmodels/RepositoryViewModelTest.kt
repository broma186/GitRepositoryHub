package com.example.gitrepositoryhub.viewmodels

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.example.gitrepositoryhub.data.Owner
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.data.RepositoryRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RepositoryViewModelTest {

    @Mock
    private lateinit var mockRepository: Repository

    @Mock
    private lateinit var owner : Owner

    private lateinit var repositoryViewModel: RepositoryViewModel

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

        mockRepository = Repository(1, "repo-2", "The second git repo",
            "https://github.com/square/yajl-objc", owner)

        repositoryViewModel = RepositoryViewModel(mockRepository)
    }

    @Test
    fun getId(){
        assertTrue(repositoryViewModel.id == 1)
    }

    @Test
    fun getName() {
        assertTrue(repositoryViewModel.name.equals("repo-2"))
    }

    @Test
    fun getDescription() {
        assertTrue(repositoryViewModel.description.equals("The second git repo"))
    }

    @Test
    fun getHtmlUrl() {
        assertTrue(repositoryViewModel.htmlUrl.equals("https://github.com/square/yajl-objc"))
    }
}