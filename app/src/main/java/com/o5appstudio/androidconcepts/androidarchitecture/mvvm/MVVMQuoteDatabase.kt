package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MVVMQuote::class], exportSchema = false, version = 1)
abstract class MVVMQuoteDatabase : RoomDatabase() {
    abstract fun mvvmQuoteDao() : MVVMQuoteDao

    companion object {

        private var INSTANCE : MVVMQuoteDatabase? = null
        fun getDatabase(context:Context) : MVVMQuoteDatabase {

            if(INSTANCE == null){

                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, MVVMQuoteDatabase::class.java,"mvvmQuotesDB")
                        .createFromAsset("quotes.db")
                        .build()
                }

            }

            return INSTANCE!!
        }

    }

}