package com.example.pinterest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertFavorite(favorites: Favorites)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<Favorites>>
}