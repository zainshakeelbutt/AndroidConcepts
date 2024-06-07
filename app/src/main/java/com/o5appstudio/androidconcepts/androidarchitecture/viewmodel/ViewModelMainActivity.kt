package com.o5appstudio.androidconcepts.androidarchitecture.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.o5appstudio.androidconcepts.R

class ViewModelMainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    lateinit var textCounter : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_main)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(10))[MainViewModel::class.java]

        textCounter = findViewById(R.id.textCounter)
        setTxt()
    }

    private fun setTxt() {
        textCounter.text = mainViewModel.count.toString()
    }

    fun increment(view: View) {
        mainViewModel.increment()
        setTxt()
    }
}