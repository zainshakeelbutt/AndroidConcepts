package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MVVMViewModelFactory(private val mvvmQuoteRepository: MVVMQuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVVMViewModel(mvvmQuoteRepository) as T
    }
}