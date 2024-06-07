package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.o5appstudio.androidconcepts.androidarchitecture.mvvm.MVVMQuoteDatabase
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.model.Result

@Database(entities = [Result::class], exportSchema = false, version = 1)
abstract class QuotableDatabase : RoomDatabase(){

    abstract fun quoteDao() : QuotableDao

    companion object{
        private var INSTANCE : QuotableDatabase? = null
        fun getDatabase(context: Context) : QuotableDatabase {

            if(INSTANCE == null){

                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, QuotableDatabase::class.java,"quotableDB")
                        .build()
                }

            }

            return INSTANCE!!
        }
    }


}