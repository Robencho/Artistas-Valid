package com.example.artist.ui.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artist.R
import com.example.artist.models.Artists
import com.example.artist.ui.ArtistDetailActivity
import com.example.artist.utils.inflate
import kotlinx.android.synthetic.main.item_artist_list.view.*

class ArtistAdapter(val artistsData: List<Artists>?):RecyclerView.Adapter<ArtistAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdapter.Holder {
       return Holder(parent.inflate(R.layout.item_artist_list))
    }

    override fun getItemCount(): Int {
        return artistsData!!.size
    }

    override fun onBindViewHolder(holder: ArtistAdapter.Holder, position: Int) {
        holder.bindView(artistsData!![position])
    }
    class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindView(artis: Artists){
            with(artis){
                itemView.txt_artist_name.text = name
                itemView.txt_artist_listener.text = "Listened: ${listeners}"
                Glide.with(itemView.context)
                    .load(image[2].text)
                    .centerCrop()
                    .into(itemView.img_artist_image)

                itemView.btn_go_to_detail.setOnClickListener {
                    var intent = Intent(itemView.context, ArtistDetailActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("listeners",listeners)
                    intent.putExtra("url",url)
                    intent.putExtra("image",image[3].text)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}