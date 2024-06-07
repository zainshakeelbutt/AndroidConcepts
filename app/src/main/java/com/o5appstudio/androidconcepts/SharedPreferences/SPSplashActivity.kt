package com.o5appstudio.androidconcepts.SharedPreferences

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class SPSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spsplash)
        val handler = Handler(mainLooper)
        handler.postDelayed({
            val pref = getSharedPreferences("login", MODE_PRIVATE)
            val check = pref.getBoolean("signin",false)
            val iIntent : Intent = if(check){
                Intent(this, SPHomeMainActivity::class.java)
            } else {
                Intent(this, SPLoginActivity::class.java)
            }
            startActivity(iIntent)
            finish()
        },4000)
    }
}