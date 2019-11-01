package com.example.gitrepositoryhub.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dagger.Provides
import javax.inject.Inject

/*
Not injected as a dependency yet as these database calls are not needed
in the current implementation. Inserts/gets the local RoomRepository objects.
 */
@Dao
interface RepositoryDao {

    @Query("SELECT * FROM repository")
    fun getRepositories(): LiveData<List<RoomRepository>>

    @Query("SELECT * FROM repository WHERE id = :id")
    fun getRepository(id : Int?): LiveData<List<RoomRepository>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repositories: List<RoomRepository>?)
}