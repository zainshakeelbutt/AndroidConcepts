package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api.QuoteService
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.model.QuotableMVVM
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.roomdb.QuotableDatabase
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.utils.NetworkUtils

class  QuotesRepository(
    private val quoteService: QuoteService,
    private val quotableDatabase: QuotableDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<Response<QuotableMVVM>>()

    val quotes: LiveData<Response<QuotableMVVM>>
        get() = quotesLiveData

    suspend fun getQuotes(page:Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){

            try {
                val result = quoteService.getQuotes(page)
                if(result.body() != null){
                    quotableDatabase.quoteDao().deleteAllQuotes()
                    quotableDatabase.quoteDao().addQuote(result.body()!!.results)
                    quotesLiveData.postValue(Response.Success(result.body()))
                }
            }
            catch (e: Exception){
                quotesLiveData.postValue(Response.Failure(e.message.toString()))
            }


        } else {

            try {
                val quotes = quotableDatabase.quoteDao().getQuotes()
                val quoteList = QuotableMVVM(1,1,1, quotes,1,1)
                quotesLiveData.postValue(Response.Success(quoteList))
            }catch (e:Exception){
                quotesLiveData.postValue(Response.Failure(e.message.toString()))
            }


        }


    }
}