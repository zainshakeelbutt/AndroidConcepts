package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MVVMViewModel(private val mvvmRepository : MVVMQuoteRepository) : ViewModel() {

    fun getQuotes() : LiveData<List<MVVMQuote>>{
        return mvvmRepository.getQuote()
    }

    fun insertQuote(mvvmQuote: MVVMQuote){
        viewModelScope.launch(Dispatchers.IO) {
             mvvmRepository.insertQuote(mvvmQuote)
        }

    }

}