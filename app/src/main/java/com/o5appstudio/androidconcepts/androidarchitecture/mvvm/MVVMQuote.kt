package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class MVVMQuote(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "text")
    val text:String,
    @ColumnInfo(name = "author")
    val author: String
)
