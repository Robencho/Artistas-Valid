package com.example.artist.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("topartists")
    val topartists: Topartists = Topartists()
)

data class Topartists(
    @SerializedName("artist")
    val artist: List<Artists> = listOf(),
    @SerializedName("@attr")
    val attr: Attr = Attr()
)

data class Artists(
    @SerializedName("image")
    val image: List<Image> = listOf(),
    @SerializedName("listeners")
    val listeners: String = "",
    @SerializedName("mbid")
    val mbid: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("streamable")
    val streamable: String = "",
    @SerializedName("url")
    val url: String = ""
)

data class Image(
    @SerializedName("size")
    val size: String = "",
    @SerializedName("#text")
    val text: String = ""
)

data class Attr(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("page")
    val page: String = "",
    @SerializedName("perPage")
    val perPage: String = "",
    @SerializedName("total")
    val total: String = "",
    @SerializedName("totalPages")
    val totalPages: String = ""
)