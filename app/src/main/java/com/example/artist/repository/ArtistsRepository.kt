package com.example.artist.repository

import com.example.artist.data.IArtist
import com.example.artist.models.ArtistResponse
import retrofit2.Call

class ArtistsRepository(private val artisDao:IArtist) {
    val allArtists: Call<ArtistResponse> = artisDao.getmArtists()
}