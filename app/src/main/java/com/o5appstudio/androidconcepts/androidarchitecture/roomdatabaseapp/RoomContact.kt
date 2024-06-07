package com.o5appstudio.androidconcepts.androidarchitecture.roomdatabaseapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "RoomContact")
data class RoomContact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "contact")
    val contact: String,
    @ColumnInfo(name = "createdDate")
    val createdDate: Date,
    @ColumnInfo(name = "isActive")
    val isActive: Int

)
