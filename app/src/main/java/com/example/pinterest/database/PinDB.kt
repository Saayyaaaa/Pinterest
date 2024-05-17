package com.example.pinterest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Favorites::class], version = 1)
abstract class PinDB : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDb(context: Context): PinDB{
            return Room.databaseBuilder(
                context.applicationContext,
                PinDB::class.java,
                "favorites.db"
            ).build()
        }
    }

}