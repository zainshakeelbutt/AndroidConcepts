package com.o5appstudio.androidconcepts.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.o5appstudio.androidconcepts.MainActivity

import com.o5appstudio.androidconcepts.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val iHome = Intent(this, MainActivity ::class.java)

        val handler = Handler(mainLooper)
        handler.postDelayed({
            startActivity(iHome)
            finish()

        }, 500)


    }
}