package com.o5appstudio.androidconcepts.quizapp.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.repository.Repositories

class SignupQuizActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var  edtEmail : EditText
    lateinit var  edtPassword : EditText
    lateinit var  edtConfirmPassword : EditText
    var repo = Repositories()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_quiz)
        firebaseAuth =FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        edtConfirmPassword = findViewById(R.id.edtRePassword)

        val btnLogin :TextView  = findViewById(R.id.btnLogin)
        val btnSignup : Button = findViewById(R.id.btnSignup)

        btnLogin.setOnClickListener{
            Repositories().simpleNavigate(this, LoginQuizActivity::class.java)
            finish()
        }

        btnSignup.setOnClickListener {
            signUpUser()
        }

    }

    private fun signUpUser(){

        val email = edtEmail.text.toString()
        val password = edtPassword.text.toString()
        val confirmPassword = edtConfirmPassword.text.toString()
        if(email.isBlank() || password.isBlank() || confirmPassword.isBlank()){
            Toast.makeText(this,"Fill All Fields", Toast.LENGTH_SHORT).show()
            return
        }
        if(password != confirmPassword){
            Toast.makeText(this,"Password and Confirm Password Mismatched", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){

                    edtEmail.text.clear()
                    edtPassword.text.clear()
                    edtConfirmPassword.text.clear()
                    Toast.makeText(this,"Sign up Successful", Toast.LENGTH_SHORT).show()
                    repo.simpleNavigate(this, HomeQuizActivity::class.java)
                    finish()

                } else{
                    Toast.makeText(this,"Error Creating user", Toast.LENGTH_SHORT).show()
                }
            }
    }


}