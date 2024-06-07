package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.auth.User
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.api.UserService
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model.Users

class UsersRepository(private val userService: UserService) {

    private val usersLiveData = MutableLiveData<UsersResponse<Users>>()
            val usersList : LiveData<UsersResponse<Users>>
                get() = usersLiveData

    suspend fun getUsers() {
        usersLiveData.postValue(UsersResponse.Loading())

        try {
            val result = userService.getUsers()
            if(result != null){
                usersLiveData.postValue(UsersResponse.Success(result.body()))
            }
        } catch (e: Exception){
            usersLiveData.postValue(UsersResponse.Failure(e.message.toString()))
        }


    }

}