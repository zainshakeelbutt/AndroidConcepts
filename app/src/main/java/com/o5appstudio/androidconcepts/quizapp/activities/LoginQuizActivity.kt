package com.o5appstudio.androidconcepts.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.repository.Repositories

class LoginQuizActivity : AppCompatActivity() {
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_quiz)
        firebaseAuth = FirebaseAuth.getInstance()
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        val btnLogin : Button = findViewById(R.id.btnLogin)
        val btnSignup : TextView = findViewById(R.id.btnSignup)

        btnSignup.setOnClickListener{
            val iIntent = Intent(this, SignupQuizActivity::class.java)
            startActivity(iIntent)
            finish()
        }
        btnLogin.setOnClickListener {
            loginUser()
        }


    }

    private fun loginUser(){
        val email = edtEmail.text.toString()
        val password = edtPassword.text.toString()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this,"Fill All Fields", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                    Repositories().simpleNavigate(this, HomeQuizActivity::class.java)
                    finish()
                } else {
                    Toast.makeText(this,"Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            }


    }

}