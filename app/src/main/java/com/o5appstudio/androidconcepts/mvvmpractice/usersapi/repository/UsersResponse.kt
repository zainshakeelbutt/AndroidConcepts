package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository

sealed class UsersResponse<T>(val data: T ?=null, val errorMessage: String? = null) {

    class Loading<T> : UsersResponse<T>()
    class Success<T>(data: T? = null) : UsersResponse<T>(data = data)
    class Failure<T>(errorMessage: String? = null) : UsersResponse<T>(errorMessage = errorMessage)

}