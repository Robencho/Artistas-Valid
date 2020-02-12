package com.example.artist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.artist.models.Artist

@Dao
interface IArtistDao {
    @Query("SELECT * FROM bd_artist ORDER BY id_artist")
    fun getAllArtists():LiveData<List<Artist>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArtist(artis:Artist)
}