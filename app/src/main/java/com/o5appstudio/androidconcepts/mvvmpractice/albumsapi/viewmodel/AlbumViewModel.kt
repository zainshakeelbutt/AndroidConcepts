package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model.AlbumList
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository.AlbumRepository
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository.AlbumResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AlbumViewModel(val repository: AlbumRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAlbum()
        }
    }

    val albumList : LiveData<AlbumResponse<AlbumList>>
        get() = repository.albumList

}