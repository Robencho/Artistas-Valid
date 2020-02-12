package com.example.artist.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bd_artist")
data class Artist(
    @PrimaryKey(autoGenerate = true) val id_artist:Int,
    @ColumnInfo(name="name")val name: String = "",
    @ColumnInfo(name="listeners")var listeners: Int,
    @ColumnInfo(name="url") var url: String = "",
    @ColumnInfo(name="image") var image: String = ""
)