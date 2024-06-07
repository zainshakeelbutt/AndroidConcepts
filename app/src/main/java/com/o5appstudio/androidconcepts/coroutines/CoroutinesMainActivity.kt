package com.o5appstudio.androidconcepts.coroutines

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.databinding.ActivityCoroutinesMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class CoroutinesMainActivity : AppCompatActivity() {
    var count = 0
    lateinit var binding: ActivityCoroutinesMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.counter.text = count.toString()

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    fun addCounter(view: View) {
        count++
        binding.counter.text = count.toString()

    }
    //Simple Coroutines launch
    private fun doSomeLongTask(){
        for(i in 1..1000000000L){

        }
    }

    fun otherTask(view: View) {

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("CoRoutines", Thread.currentThread().name)
            doSomeLongTask()
        }

        GlobalScope.launch(Dispatchers.Main){
            Log.d("CoRoutines", Thread.currentThread().name)
        }

        MainScope().launch(Dispatchers.Default){
            Log.d("CoRoutines", Thread.currentThread().name)
        }

    }


    //Suspending Functions
    fun suspendingFun(view: View) {

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }


    }

    suspend fun task1(){
        Log.d("tasks", "Starting Task 1")
        yield()
        Log.d("tasks", "Ending Task 1")
    }
    suspend fun task2(){
        Log.d("tasks", "Starting Task 2")
        yield()
        Log.d("tasks", "Ending Task 2")
    }

    suspend fun printFbFollowers(view: View) {



    }

    // With Launch

//    private suspend fun printFollowers(){
//        var fbFollowers = 0
//        var instaFollowers = 0
//
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//        }
//
//        val job2 = CoroutineScope(Dispatchers.IO).launch {
//            instaFollowers = getInstaFollowers()
//        }
//
//        job.join()
//        job2.join()
//        Log.d("Followers","Fb Followers = $fbFollowers \nInstaFollowers = $instaFollowers")
//
//    }

    // With Async

    private suspend fun printFollowers(){
//
//        val fb = CoroutineScope(Dispatchers.IO).async {
//            getFbFollowers()
//        }
//
//        val insta = CoroutineScope(Dispatchers.IO).async {
//            getInstaFollowers()
//        }

       CoroutineScope(Dispatchers.IO).launch {
           val fb = async { getFbFollowers() }
           val insta = async { getInstaFollowers() }
           Log.d("Followers","Fb Followers = ${fb.await()} \nInstaFollowers = ${insta.await()}")
        }


//        Log.d("Followers","Fb Followers = ${fb.await()} \nInstaFollowers = ${insta.await()}")


    }

    private suspend fun getFbFollowers() : Int{
        delay(1000)
        return 54
    }

    private suspend fun getInstaFollowers() : Int{
        delay(1000)
        return 132
    }


}