package com.example.jetweatherforecast.model

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "fav_tbl")
data class Favorite(
    @SuppressLint("KotlinNullnessAnnotation")
    @PrimaryKey
    @NotNull
    @ColumnInfo(name="city")
    val city:String,

    @ColumnInfo(name="country")
    val country:String
)
