package com.o5appstudio.androidconcepts.fragments.staticfragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.fragments.dynamicfragments.DynamicFragmentsActivity

class FragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)
        val dynamicFrags : Button = findViewById(R.id.dynamicFrags)

        dynamicFrags.setOnClickListener{
            val iIntent = Intent(this, DynamicFragmentsActivity::class.java)
            startActivity(iIntent)
        }
    }
}