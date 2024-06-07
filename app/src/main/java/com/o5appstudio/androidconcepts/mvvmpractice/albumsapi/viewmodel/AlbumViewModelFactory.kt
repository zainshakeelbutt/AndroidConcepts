package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository.AlbumRepository

class AlbumViewModelFactory(val repository: AlbumRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumViewModel(repository) as T
    }
}