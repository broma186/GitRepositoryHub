package com.example.gitrepositoryhub.data

import androidx.room.*
import javax.inject.Inject

/*
Can be substituted in for the Repository class when Room is implemented.
Not needed currently as we can do a one shot request for repositories via
 the network module when the app is opened.
 */
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







