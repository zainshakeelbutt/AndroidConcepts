package com.o5appstudio.androidconcepts.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        val nextBtn : Button = findViewById(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val iNext = Intent(this, SecondActivity :: class.java)
            iNext.putExtra("name", "Zain")
            iNext.putExtra("age",32)
            iNext.putExtra("city", "Gujrat")
                    startActivity(iNext)
        }
    }
}