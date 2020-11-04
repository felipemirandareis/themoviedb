package com.mirandafelipe.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre")
data class GenreEntity(
    @PrimaryKey(autoGenerate = true) val primaryKey: Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String
)