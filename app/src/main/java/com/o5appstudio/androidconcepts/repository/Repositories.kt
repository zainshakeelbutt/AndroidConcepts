package com.o5appstudio.androidconcepts.repository

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

open class Repositories {

    fun simpleNavigate(context: Context, activity : Class<*>){
        val iIntent = Intent(context, activity)
        context.startActivity(iIntent)
    }


}