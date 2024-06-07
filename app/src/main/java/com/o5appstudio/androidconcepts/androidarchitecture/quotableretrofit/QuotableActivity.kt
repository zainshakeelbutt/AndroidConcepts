package com.o5appstudio.androidconcepts.androidarchitecture.quotableretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuotableActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotable)

        val quotesAPi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result = quotesAPi.getQuotes(1)
            if(result != null){
                val quoteLists = result.body()
                if (quoteLists != null) {
                    quoteLists.results.forEach({
                        Log.d("Quotable", it.content)

                    })
                }
            }
        }
    }
}