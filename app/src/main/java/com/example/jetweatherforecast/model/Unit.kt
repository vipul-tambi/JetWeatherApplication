package com.example.jetweatherforecast.model

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName="settings_tbl")
data class Unit(
    @SuppressLint("KotlinNullnessAnnotation")
    @NotNull
    @PrimaryKey
    @ColumnInfo(name="unit")
    val unit:String

)
