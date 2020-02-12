package com.example.artist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.artist.models.Artist

@Database(entities = arrayOf(Artist::class),version = 1, exportSchema = false)
public abstract class ArtistsRoomDatabase:RoomDatabase() {
    abstract fun artistDao():IArtistDao

    companion object{
        @Volatile
        private var INSTANCE: ArtistsRoomDatabase? = null

        fun getDatabase(context: Context):ArtistsRoomDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    ArtistsRoomDatabase::class.java,
                    "bd_artists"
                ).build()
                INSTANCE = instace
                return instace
            }
        }
    }
}