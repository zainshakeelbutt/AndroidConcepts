package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitMVVMHelper {

    private const val BASE_URL = "https://quotable.io/"

    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}