package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api

import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.model.QuotableMVVM
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int) : Response<QuotableMVVM>
}