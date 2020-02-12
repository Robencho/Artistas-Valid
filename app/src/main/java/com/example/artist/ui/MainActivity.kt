package com.example.artist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gotoArtists()
    }

    fun gotoArtists(){
        btn_go_to_artists.setOnClickListener {
            var intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
    }
}
