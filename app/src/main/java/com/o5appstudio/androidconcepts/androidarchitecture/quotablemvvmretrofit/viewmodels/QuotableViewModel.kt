package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.model.QuotableMVVM
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository.QuotesRepository
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotableViewModel(private val repository: QuotesRepository) : ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<Response<QuotableMVVM>>
        get() = repository.quotes


}