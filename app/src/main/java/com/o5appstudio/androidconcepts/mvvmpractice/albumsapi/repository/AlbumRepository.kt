package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.api.AlbumServices
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model.AlbumList

class AlbumRepository(private val albumServices: AlbumServices) {

    private val albumsLiveData = MutableLiveData<AlbumResponse<AlbumList>>()
            val albumList : LiveData<AlbumResponse<AlbumList>>
                get() =  albumsLiveData

    suspend fun getAlbum(){
        val  result = albumServices.getAlbums()
        if(result != null){
            albumsLiveData.postValue(AlbumResponse.Success(result.body()))
        }
    }

}