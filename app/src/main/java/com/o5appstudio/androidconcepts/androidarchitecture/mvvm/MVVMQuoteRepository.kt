package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import androidx.lifecycle.LiveData

class MVVMQuoteRepository(private val mvvmQuotesDao : MVVMQuoteDao) {


    fun getQuote() : LiveData<List<MVVMQuote>>{
        return  mvvmQuotesDao.getQuotes()
    }

    suspend fun insertQuote(mvvmQuote: MVVMQuote){
        mvvmQuotesDao.insertQuotes(mvvmQuote)
    }
}