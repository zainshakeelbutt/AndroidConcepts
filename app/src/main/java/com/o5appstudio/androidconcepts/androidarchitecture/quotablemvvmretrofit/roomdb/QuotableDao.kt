package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.model.Result

@Dao
interface QuotableDao {

    @Query("SELECT * FROM quotable")
    suspend fun getQuotes() : List<Result>

    @Query("Delete FROM quotable")
    suspend fun deleteAllQuotes()

    @Insert
    suspend fun addQuote(quote: List<Result>)

}