package com.o5appstudio.androidconcepts.newsapp

import android.provider.MediaStore.Audio.Artists

data class News (val totalResults:Int, val articles: List<Atricles>)