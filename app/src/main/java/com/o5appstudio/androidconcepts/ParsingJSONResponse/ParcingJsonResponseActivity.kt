package com.o5appstudio.androidconcepts.ParsingJSONResponse

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.o5appstudio.androidconcepts.R
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class ParcingJsonResponseActivity : AppCompatActivity() {
    val url = "https://jsonplaceholder.typicode.com/users" //Get
    private lateinit var listViewApi : ListView
    private val client = OkHttpClient()

    lateinit var arrNames: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parching_json_response)
        listViewApi  = findViewById(R.id.listViewApi)
        arrNames = ArrayList()

        fetchPost()
    }

    private fun fetchPost(){
        val request = Request.Builder()
            .url(url)
            .build()


        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("MainActivity", "Error: ${e.message}")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("RES",response.toString())
                response.use {
                        try {
                            if(!it.isSuccessful) throw IOException("UnExpected Code $response")
                            val jsonArray = JSONArray(it.body?.string() ?: "")
                            Log.d("JsonArray",jsonArray.toString())
                            for(i in 0 until jsonArray.length()){
                                val jsonObject: JSONObject = jsonArray.getJSONObject(i)

                                val name = jsonObject.getString("name")

                                arrNames.add(name)

                                Log.d("Names",jsonObject.toString())

                            }
                            runOnUiThread{
                                val arrayAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, arrNames)
                                listViewApi.adapter = arrayAdapter
                            }



                        }
                        catch (e:IOException){
                            e.printStackTrace()
                        }





                }


            }

        })

    }
}