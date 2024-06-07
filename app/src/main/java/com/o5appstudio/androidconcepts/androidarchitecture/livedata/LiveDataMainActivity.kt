package com.o5appstudio.androidconcepts.androidarchitecture.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.o5appstudio.androidconcepts.databinding.ActivityLiveDataMainBinding
import com.o5appstudio.androidconcepts.androidarchitecture.quotesapp.Quote

class LiveDataMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataMainBinding
    lateinit var liveDataViewModel: LiveDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        liveDataViewModel = ViewModelProvider(this)[LiveDataViewModel::class.java]
        binding.lifecycleOwner = this
        binding.liveDataViewModel = liveDataViewModel

//        val quoteObj = Quote("This is My Quote", "Zain Shakeel")



    }
}
