package com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api.QuoteService
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.api.RetrofitMVVMHelper
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository.QuotesRepository
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.repository.Response
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.viewmodels.QuotableViewModel
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.viewmodels.QuotableViewModelFactory
import com.o5appstudio.androidconcepts.androidarchitecture.quotableretrofit.RetrofitHelper
import com.o5appstudio.androidconcepts.databinding.ActivityQuotableMvvmactivityBinding

class QuotableMVVMActivity : AppCompatActivity() {

    private lateinit var quotableViewModel: QuotableViewModel
    private lateinit var binding: ActivityQuotableMvvmactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuotableMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quotesRepository = (application as QuoteApplication).quotesRepository

        quotableViewModel = ViewModelProvider(this,QuotableViewModelFactory(quotesRepository))[QuotableViewModel::class.java]

        quotableViewModel.quotes.observe(this, Observer { it ->
            when(it){
                is Response.Failure -> {
                    Toast.makeText(this,"Some Error",Toast.LENGTH_SHORT).show()

                }
                is Response.Loading -> {
                    TODO()
                }
                is Response.Success -> {
                    it.data.let {
                        if (it != null) {
                            Toast.makeText(this,it.results.size.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        })

        }
    }
