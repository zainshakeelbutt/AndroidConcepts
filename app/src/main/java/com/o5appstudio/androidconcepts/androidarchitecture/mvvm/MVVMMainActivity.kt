package com.o5appstudio.androidconcepts.androidarchitecture.mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.databinding.ActivityMvvmmainBinding

class MVVMMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMvvmmainBinding
    private lateinit var mainViewModel : MVVMViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = MVVMQuoteDatabase.getDatabase(applicationContext).mvvmQuoteDao()
        val quoteRepository = MVVMQuoteRepository(dao)
        mainViewModel = ViewModelProvider(this, MVVMViewModelFactory(quoteRepository))[MVVMViewModel::class.java]

        mainViewModel.getQuotes().observe(this, Observer {
            binding.mvvmQuotes = it.toString()
        })
        binding.btnAddQuote.setOnClickListener {
            val quote = MVVMQuote(0,"This is Testing","Testing")
            mainViewModel.insertQuote(quote)
        }


    }
}