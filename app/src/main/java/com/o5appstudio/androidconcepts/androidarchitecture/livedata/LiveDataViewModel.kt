package com.o5appstudio.androidconcepts.androidarchitecture.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    private val factsLiveDataObject = MutableLiveData("This is a fact")
    val factsLiveData : LiveData<String>
        get() {
            return  factsLiveDataObject
        }

    fun updateLiveData(){
        factsLiveDataObject.value = "Another Value"
    }

}