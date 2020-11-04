package com.mirandafelipe.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val primaryKey: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "genres") val genres: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "backdrop") val backdrop: String
)