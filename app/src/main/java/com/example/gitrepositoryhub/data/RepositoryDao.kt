package com.example.gitrepositoryhub.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dagger.Provides
import javax.inject.Inject


@Dao
interface RepositoryDao {

    @Query("SELECT * FROM repository")
    fun getRepositories(): LiveData<List<RoomRepository>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repositories: List<RoomRepository>?)
}