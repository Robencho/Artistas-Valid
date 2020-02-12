package com.example.artist.data

import com.example.artist.models.Artist
import com.example.artist.models.ArtistResponse
import retrofit2.Call
import retrofit2.http.GET

interface IArtist {
    @GET("?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getArtists():retrofit2.Call<List<Artist>>

    @GET("?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getmArtists():Call<ArtistResponse>
}