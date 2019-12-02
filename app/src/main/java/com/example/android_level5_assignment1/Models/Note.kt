package com.example.android_level5_assignment1.Models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "noteTable")
data class Note(
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "lastUpdated")
    val lastUpdated: Date,
    @ColumnInfo(name = "text")
    val text : String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Long? = null
    ) : Parcelable