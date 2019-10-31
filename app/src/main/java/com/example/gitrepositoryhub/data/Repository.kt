package com.example.gitrepositoryhub.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import javax.inject.Inject


@Entity(
    tableName = "repository",
    indices = [Index("id")]
)

data class Repository (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?
)
