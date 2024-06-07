package com.o5appstudio.androidconcepts.androidarchitecture.quotesapp

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset

class QuotesViewModel(val context: Context) : ViewModel() {

    var quotesList : Array<Quote> = emptyArray<Quote>()
    var index = 0
    
    init {
        quotesList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {
        val inputStream  = context.assets.open("Quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson().fromJson(json, Array<Quote>::class.java)
        return  gson
    }

    fun getQuote(): Quote {
        return quotesList[index]
    }

    fun getNextQuote(): Quote {
        return quotesList[++index]
    }

    fun getPrevQuote(): Quote {
        return quotesList[--index]
    }

}