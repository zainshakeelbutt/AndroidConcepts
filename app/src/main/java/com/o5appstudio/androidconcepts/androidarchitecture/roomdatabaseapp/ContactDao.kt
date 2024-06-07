package com.o5appstudio.androidconcepts.androidarchitecture.roomdatabaseapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact: RoomContact)

    @Update
    suspend fun updateContact(contact: RoomContact)

    @Delete
    suspend fun deleteContact(contact: RoomContact)

    @Query("SELECT * FROM RoomContact")
    fun getContact() : LiveData<List<RoomContact>>



}