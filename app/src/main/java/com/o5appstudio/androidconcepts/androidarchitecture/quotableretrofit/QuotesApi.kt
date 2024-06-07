package com.o5appstudio.androidconcepts.androidarchitecture.quotableretrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Response<Quotable>
}