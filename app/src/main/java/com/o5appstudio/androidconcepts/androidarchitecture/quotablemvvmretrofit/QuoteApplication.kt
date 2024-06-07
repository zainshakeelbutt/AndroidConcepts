package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit

import android.app.Application
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api.QuoteService
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api.RetrofitMVVMHelper
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository.QuotesRepository
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.roomdb.QuotableDatabase

class QuoteApplication : Application() {
    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }
    private fun initialize(){
        val quoteService = RetrofitMVVMHelper.getInstance().create(QuoteService::class.java)
        val database = QuotableDatabase.getDatabase(applicationContext)
        quotesRepository = QuotesRepository(quoteService,database, applicationContext)
    }
}