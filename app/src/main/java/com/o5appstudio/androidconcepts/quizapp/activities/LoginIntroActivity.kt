package com.o5appstudio.androidconcepts.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.o5appstudio.androidconcepts.R

class LoginIntroActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)
        firebaseAuth = FirebaseAuth.getInstance()
        val btnGetStarted : Button = findViewById(R.id.btnGetStarted)

        if(firebaseAuth.currentUser != null){
            redirect("MAIN")
        }

        btnGetStarted.setOnClickListener {
            redirect("LOGIN")
        }

    }

    private fun redirect(screen:String){
        val iIntent = when(screen){
            "LOGIN" -> Intent(this, LoginQuizActivity::class.java)
            "MAIN" -> Intent(this, HomeQuizActivity::class.java)
            else -> throw Exception("Npo Path Found")
        }
        startActivity(iIntent)
        finish()
    }
}