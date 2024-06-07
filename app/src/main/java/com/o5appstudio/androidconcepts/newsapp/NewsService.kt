package com.o5appstudio.androidconcepts.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=us&apiKey=63f33711c2e8402db1e3d7ed32023ad7
// https://newsapi.org/v2/everything?q=bitcoin&apiKey=63f33711c2e8402db1e3d7ed32023ad7

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "63f33711c2e8402db1e3d7ed32023ad7"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String, @Query("page") pages:Int) : Call<News>

    //https://newsapi.org/v2/top-headlines?apiKey=63f33711c2e8402db1e3d7ed32023ad7&country=us&page=1

}

object NewsService {
    val newsInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}