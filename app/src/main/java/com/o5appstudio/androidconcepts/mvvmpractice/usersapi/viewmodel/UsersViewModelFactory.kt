package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository.UsersRepository

class UsersViewModelFactory(val repository: UsersRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(repository) as T
    }

}