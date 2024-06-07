package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.api

import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model.AlbumList
import retrofit2.Response
import retrofit2.http.GET

interface AlbumServices {

    @GET("/photos")
    suspend fun getAlbums() : Response<AlbumList>

}