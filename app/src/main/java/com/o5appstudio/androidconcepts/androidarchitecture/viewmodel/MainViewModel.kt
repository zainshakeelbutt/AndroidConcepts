package com.o5appstudio.androidconcepts.androidarchitecture.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(initialValue : Int) : ViewModel() {

    var count = initialValue

    fun increment(){
        count++
    }
}