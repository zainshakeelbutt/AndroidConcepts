package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model

data class AlbumListItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)