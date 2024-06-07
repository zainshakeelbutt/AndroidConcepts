package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model.Users
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository.UsersRepository
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(val repository: UsersRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsers()
        }
    }

    val usersList : LiveData<UsersResponse<Users>>
        get() = repository.usersList


}