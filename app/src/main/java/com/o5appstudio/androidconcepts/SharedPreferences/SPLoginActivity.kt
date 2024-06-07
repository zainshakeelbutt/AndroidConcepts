package com.o5appstudio.androidconcepts.SharedPreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R
import kotlin.math.log

class SPLoginActivity : AppCompatActivity() {
    lateinit var login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sp_login)
        login = findViewById(R.id.loginBtn)

        login.setOnClickListener{

            val pref = getSharedPreferences("login", MODE_PRIVATE)

            val editor = pref.edit()
            editor.putBoolean("signin", true)
            editor.apply()

            val iIntent = Intent(this,SPHomeMainActivity::class.java)
            startActivity(iIntent)
        }

    }
}