package com.o5appstudio.androidconcepts.androidarchitecture.quotesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.o5appstudio.androidconcepts.R

class QuotesAppMainActivity : AppCompatActivity() {
    lateinit var quotesViewModel: QuotesViewModel
    lateinit var quoteText : TextView
    lateinit var quoteAuthor : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes_app_main)
        quotesViewModel = ViewModelProvider(this,QuotesViewModelFactory(application))[QuotesViewModel::class.java]
        quoteText = findViewById(R.id.quoteText)
        quoteAuthor = findViewById(R.id.quoteAuthor)
        setQuote(quotesViewModel.getQuote())

    }
    private fun setQuote(quote:Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        if(quotesViewModel.index > 0){
            setQuote(quotesViewModel.getPrevQuote())
        } else {
            Toast.makeText(this,"Move Next",Toast.LENGTH_SHORT).show()
        }

    }
    fun onNext(view: View) {
        if(quotesViewModel.index < quotesViewModel.quotesList.size){
            setQuote(quotesViewModel.getNextQuote())
        } else {
            Toast.makeText(this,"Move Previous",Toast.LENGTH_SHORT).show()
        }

    }

    fun onShare(view: View) {
        val iIntent = Intent(Intent.ACTION_SEND)
        iIntent.setType("text/plain")
        iIntent.putExtra(Intent.EXTRA_TEXT, "${quotesViewModel.getQuote().text}\n\n${quotesViewModel.getQuote().author}")
        startActivity(iIntent)
    }
}