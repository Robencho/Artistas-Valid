package com.example.artist.repository

import androidx.lifecycle.LiveData
import com.example.artist.data.IArtistDao
import com.example.artist.models.Artist

class ArtistRepository(private val artistDao:IArtistDao) {
    val allArtists:LiveData<List<Artist>> = artistDao.getAllArtists()
    suspend fun insertArtist(artist:Artist){
        artistDao.insertArtist(artist)
    }
}