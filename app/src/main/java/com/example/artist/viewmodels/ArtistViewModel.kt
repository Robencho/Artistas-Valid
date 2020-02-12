package com.example.artist.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.artist.data.ArtistsRoomDatabase
import com.example.artist.models.Artist
import com.example.artist.repository.ArtistRepository
import kotlinx.coroutines.launch

class ArtistViewModel(application: Application):AndroidViewModel(application) {

    private val repository:ArtistRepository
    val allArtists:LiveData<List<Artist>>

    init {
        val artisDao = ArtistsRoomDatabase.getDatabase(application).artistDao()
        repository = ArtistRepository(artisDao)
        allArtists = repository.allArtists

    }
    fun insertArtist(artist:Artist)=viewModelScope.launch {
        repository.insertArtist(artist)
    }
}