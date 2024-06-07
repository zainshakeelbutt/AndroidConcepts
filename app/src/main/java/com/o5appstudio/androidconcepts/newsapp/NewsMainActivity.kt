package com.o5appstudio.androidconcepts.newsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.o5appstudio.androidconcepts.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsMainActivity : ComponentActivity() {
    lateinit var adapter: NewsAdapter
    lateinit var newsList : RecyclerView
    lateinit var errorText : TextView
    lateinit var progress : ProgressBar
    lateinit var progress2 : ProgressBar
    private var articles  = mutableListOf<Atricles>()

    var pageNum  = 1
    var totalresults  = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_main)

        newsList= findViewById(R.id.newsList)
        errorText = findViewById(R.id.errorText)
        progress = findViewById(R.id.newsListProgress)
        progress2 = findViewById(R.id.newsListProgress2)


        //set visibilities

        progress.visibility = View.GONE
        newsList.visibility = View.GONE
        errorText.visibility = View.VISIBLE
        errorText.text = "Please Wait.."

        adapter = NewsAdapter(this,articles)
        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(applicationContext)

        newsList.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                Log.d("Total items", totalItemCount.toString())
                Log.d("Total items Results", totalresults.toString())


                if (lastVisibleItemPosition == totalItemCount - 1 && totalresults > totalItemCount) {
                    progress2.visibility = View.VISIBLE
                    pageNum++
                    getNews()
                }
            }

        })


        getNews()



    }

    private fun getNews() {
        progress.visibility = View.VISIBLE
        errorText.visibility = View.GONE

        val news = NewsService.newsInstance.getHeadlines("us",pageNum)
        progress2.visibility = View.GONE

        news.enqueue(object : Callback<News>{
            override fun onFailure(p0: Call<News>, p1: Throwable) {
                Log.d("O5News Error","Error in fetching news")
                progress.visibility = View.GONE
                errorText.text = "Some Error"
                errorText.visibility = View.VISIBLE
                progress2.visibility = View.GONE
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val newsResponse = response.body()
                if(newsResponse != null){
                    Log.d("O5News",newsResponse.toString())

                    totalresults = newsResponse.totalResults
                    articles.addAll(newsResponse.articles)
                    adapter.notifyDataSetChanged()

                    progress.visibility = View.GONE
                    errorText.visibility = View.GONE
                    newsList.visibility = View.VISIBLE
                }
            }


        })

    }
}

