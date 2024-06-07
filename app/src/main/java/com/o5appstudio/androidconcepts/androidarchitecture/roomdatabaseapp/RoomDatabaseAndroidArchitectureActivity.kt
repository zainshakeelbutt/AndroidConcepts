package com.o5appstudio.androidconcepts.androidarchitecture.roomdatabaseapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.databinding.ActivityRoomDatabaseAndroidArchitectureBinding
import com.o5appstudio.androidconcepts.roomdatabase.Expe
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class RoomDatabaseAndroidArchitectureActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomDatabaseAndroidArchitectureBinding
    lateinit var database : ContactDatabase
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomDatabaseAndroidArchitectureBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        database = Room.databaseBuilder(this,ContactDatabase::class.java,"RoomContactDB").build()
        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(RoomContact(0,"Zain","03425956300",Date(),1))
        }




    }

    fun getData(view: View){
        database.contactDao().getContact().observe(this) {
            Log.d("RoomDB", it.toString())
        }
    }
}