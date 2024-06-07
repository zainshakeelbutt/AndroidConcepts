package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.api

import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers() : Response<Users>
}