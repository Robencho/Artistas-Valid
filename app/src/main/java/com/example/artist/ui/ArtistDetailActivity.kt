package com.example.artist.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.artist.R
import kotlinx.android.synthetic.main.activity_artist_detail.*
import kotlinx.android.synthetic.main.item_artist_list.view.*
import kotlinx.android.synthetic.main.toolbar.*

class ArtistDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detail)
        toBack.setOnClickListener {
            onBackPressed()
        }
        txt_title_toolbar.text = "Artist Detail"

        intent?.extras?.let {

            Glide.with(this)
                .load(it.getString("image"))
                .centerCrop()
                .into(img_detail_image)

            txt_detail_name.text = it.getString("name")
            txt_detail_listener.text = "Listened: ${it.getString("listeners")}"
            txt_detail_url.text = it.getString("url")
            var urlLink = it.getString("url")
            txt_detail_url.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(urlLink))
                startActivity(intent)
            }
        }
    }
}
