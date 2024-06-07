package com.o5appstudio.androidconcepts.customtoolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.o5appstudio.androidconcepts.R

class CustomToolbarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_toolbar)

        val toolbar: Toolbar = findViewById(R.id.toolBar)

        //step1
        setSupportActionBar(toolbar)
        //step2

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Android"
        supportActionBar?.subtitle = "Learning tutorials"




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemId = item.itemId

        if(itemId == R.id.newFile){
            Toast.makeText(this,"New File", Toast.LENGTH_SHORT).show()
        } else if(itemId == R.id.openFile){
            Toast.makeText(this,"Open File", Toast.LENGTH_SHORT).show()
        } else if(itemId == R.id.saveFile){
            Toast.makeText(this,"Save File", Toast.LENGTH_SHORT).show()
        } else if(itemId == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}