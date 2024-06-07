package com.o5appstudio.androidconcepts.services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class ServicesActivity : AppCompatActivity() {

    private lateinit var startServiceBtn : Button
    private lateinit var stopServiceBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        startServiceBtn = findViewById(R.id.startServiceBtn)
        stopServiceBtn = findViewById(R.id.stopServiceBtn)

        startServiceBtn.setOnClickListener {
            startService(Intent(this,MusicService::class.java))
        }

        stopServiceBtn.setOnClickListener {
            stopService(Intent(this,MusicService::class.java))
        }

    }
}