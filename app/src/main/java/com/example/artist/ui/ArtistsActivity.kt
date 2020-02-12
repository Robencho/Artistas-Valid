package com.example.artist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artist.R
import com.example.artist.data.IArtist
import com.example.artist.models.ArtistResponse
import com.example.artist.ui.adapters.ArtistAdapter
import com.example.artist.viewmodels.ArtistViewModel
import kotlinx.android.synthetic.main.activity_artists.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArtistsActivity : AppCompatActivity() {
    private lateinit var artistViewModel: ArtistViewModel
    private var listOfArtists = mutableListOf<String>()
    companion object{
        val API_KEY = "829751643419a7128b7ada50de590067"
        var BASE_URL = "http://ws.audioscrobbler.com/2.0/"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)
        toBack.setOnClickListener {
            onBackPressed()
        }
        txt_title_toolbar.text="Top Artists"
        showArtists()
    }

    fun showArtists(){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ws.audioscrobbler.com/2.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create<IArtist>(IArtist::class.java)
        service.getmArtists().enqueue(object : Callback<ArtistResponse>{
            override fun onFailure(call: Call<ArtistResponse>, t: Throwable) {
                Log.d("Error api: ","hay un error")
            }
            override fun onResponse(call: Call<ArtistResponse>, response: Response<ArtistResponse>) {
                val responseArtists = response.body()?.topartists?.artist
                rv_artists.layoutManager = LinearLayoutManager(this@ArtistsActivity,LinearLayoutManager.VERTICAL,false)
                val adapter = ArtistAdapter(responseArtists)
                rv_artists.adapter = adapter
            }
        })
    }
}
