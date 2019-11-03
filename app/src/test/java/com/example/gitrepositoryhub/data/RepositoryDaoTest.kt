package com.example.gitrepositoryhub.data

import android.content.pm.ApplicationInfo
import androidx.room.Room
import com.nhaarman.mockito_kotlin.spy
import org.junit.After
import org.junit.Before
import org.junit.Test
import com.example.gitrepositoryhub.utils.getValue
import kotlinx.coroutines.runBlocking
import org.apache.commons.validator.routines.UrlValidator
import android.support.test.InstrumentationRegistry
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.mockito.Spy

class RepositoryDaoTest {

    private lateinit var database: AppDatabase

    private lateinit var urlValidator : UrlValidator

    @Spy
    private lateinit var repositoryDaoSpy: RepositoryDao

    val repositories: List<RoomRepository> = listOf(
        RoomRepository(1, "yajl-objc", "The first git repo", "https://github.com/square/yajl-objc"),
        RoomRepository(2, "repo-2", "The second git repo", "https://github.com/square/yajl-objc"),
        RoomRepository(3, "repo-3", "The Third git repo", "https://github.com/square/yajl-objc")
    )

    @Before
    fun setUp() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().getTargetContext()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        repositoryDaoSpy.insertAll(repositories)
        urlValidator = UrlValidator()
    }

    @Test
    fun test_html_url_valid() {
        assertTrue(urlValidator.isValid(repositories.get(0).htmlUrl))
    }

    @Test
    fun test_html_url_invalid() {
        assertTrue(urlValidator.isValid(repositories.get(0).description))
    }

    @After
    fun tearDown() {
        database.close()
    }
}