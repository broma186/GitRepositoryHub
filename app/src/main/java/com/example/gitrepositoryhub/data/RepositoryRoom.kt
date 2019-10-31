package com.example.gitrepositoryhub.data

import androidx.room.*
import javax.inject.Inject


@Entity(
    tableName = "repository",
    indices = [Index("id")]
)
data class RoomRepository (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "html_url") val htmlUrl: String?
)







