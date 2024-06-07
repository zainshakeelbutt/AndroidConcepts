package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository

sealed class AlbumResponse<T>(val data: T? = null, val errorMessage : String? =null) {

    class Loading<T> : AlbumResponse<T>()
    class Success<T>(data: T? = null) : AlbumResponse<T>(data = data)
    class Failure<T>(errorMessage: String? = null) : AlbumResponse<T>(errorMessage = errorMessage)

}