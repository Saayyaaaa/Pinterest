package com.example.pinterest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorites(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "imageUrl")
    var url: String,
    @ColumnInfo(name = "imageName")
    var name: String,
)