package com.o5appstudio.androidconcepts.newsapp

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.o5appstudio.androidconcepts.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val detailProgress : ProgressBar = findViewById(R.id.detailProgressBar)
        val detailWebView :WebView = findViewById(R.id.detailWebView)

        val url = intent.getStringExtra("url")

        if(url!=null){
            detailWebView.settings.javaScriptEnabled = true
//            detailWebView.settings.userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36\n"
            detailWebView.webViewClient  =object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    detailProgress.visibility = View.GONE
                    detailWebView.visibility = View.VISIBLE
                }
            }
            detailWebView.loadUrl(url)
        }


    }
}