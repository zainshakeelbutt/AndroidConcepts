package com.o5appstudio.androidconcepts.androidarchitecture.lifecycleawarecomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class LifeCycleAwareActivity : AppCompatActivity() {
    private lateinit var myObserver: Observer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_aware)
        Log.d("ONCREATE Main","OnCreate Main")
        myObserver = Observer()
        lifecycle.addObserver(myObserver)

    }
}