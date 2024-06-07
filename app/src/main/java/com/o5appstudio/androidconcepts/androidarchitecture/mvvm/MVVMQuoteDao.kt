package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MVVMQuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<MVVMQuote>>

    @Insert
    suspend fun insertQuotes(quote: MVVMQuote)

}