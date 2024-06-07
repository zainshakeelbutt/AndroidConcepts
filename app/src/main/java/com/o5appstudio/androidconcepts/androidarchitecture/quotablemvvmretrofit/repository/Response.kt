package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository

import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.model.QuotableMVVM


sealed class Response<T>(val data : T? = null, val errorMsg : String? = null){

    class Loading<T>: Response<T>()
    class Success<T>(data: T? = null) : Response<T>(data = data)
    class Failure<T>(errorMessage : String): Response<T>(errorMsg = errorMessage )

}