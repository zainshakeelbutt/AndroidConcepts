package com.o5appstudio.androidconcepts.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        val backBtn : Button = findViewById(R.id.backBtn)

        val name : TextView = findViewById(R.id.nameP)
        val age : TextView = findViewById(R.id.ageP)
        val city : TextView = findViewById(R.id.cityP)

        val intentS = intent

        val nameP: String = intentS.getStringExtra("name").toString()
        val ageP : Int = intentS.getIntExtra("age",0)
        val cityP: String = intentS.getStringExtra("city").toString()

        name.text = nameP
        age.text = ageP.toString()
        city.text = cityP

        supportActionBar?.title = nameP
        supportActionBar?.hide()

        backBtn.setOnClickListener {
            this.finish()
        }

    }
}