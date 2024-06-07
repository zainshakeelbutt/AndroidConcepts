package com.o5appstudio.androidconcepts.SharedPreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class SPHomeMainActivity : AppCompatActivity() {
    private lateinit var logOut : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp_home_main)

        logOut = findViewById(R.id.logoutBtn)

        logOut.setOnClickListener{
            val pref = getSharedPreferences("login", MODE_PRIVATE)

            val editor = pref.edit()
            editor.putBoolean("signin", false)
            editor.apply()

            val iIntent = Intent(this,SPLoginActivity::class.java)
            startActivity(iIntent)
            finish()
        }

    }
}