package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository.QuotesRepository

class QuotableViewModelFactory(private val repository: QuotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotableViewModel(repository) as T
    }
}