package com.o5appstudio.androidconcepts.androidarchitecture.listadapterdiffutils

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.databinding.ActivityListAdapterBinding

class ListAdapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityListAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ProgrammingAdapter()
        val p1 = ProgrammingItem(0,"D","Dart")
        val p2 = ProgrammingItem(1,"F","Flutter")
        val p3 = ProgrammingItem(2,"A","Android")
        val p4 = ProgrammingItem(3,"P","Php")

        adapter.submitList(listOf(p1,p2,p3,p4))

        binding.programmingList.layoutManager = LinearLayoutManager(this)
        binding.programmingList.setHasFixedSize(true)
        binding.programmingList.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val p5 = ProgrammingItem(3,"P","Php")
            val p6 = ProgrammingItem(1,"S","Swift")
            val p7 = ProgrammingItem(2,"C","C++")
            val p8 = ProgrammingItem(3,"H","HTML")
            adapter.submitList(listOf(p5,p6,p7,p8))


        }, 4000)

    }
}