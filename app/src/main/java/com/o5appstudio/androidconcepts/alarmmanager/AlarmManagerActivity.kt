package com.o5appstudio.androidconcepts.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.o5appstudio.androidconcepts.R

class AlarmManagerActivity : AppCompatActivity() {
    private lateinit var setTime : EditText
    private lateinit var setAlarm : Button

    companion object{
        private const val ALARM_REQ_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_manager)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        setTime = findViewById(R.id.setTime)
        setAlarm = findViewById(R.id.setAlarm)

        setAlarm.setOnClickListener {
            val time = Integer.parseInt(setTime.text.toString())
            val triggerTime = System.currentTimeMillis() + (time*1000)

            val iBroadcast = Intent(this,
                MyReceiver::class.java)
            val pi = PendingIntent.getBroadcast(this,ALARM_REQ_CODE,iBroadcast, PendingIntent.FLAG_MUTABLE)

        alarmManager.set(AlarmManager.RTC,triggerTime,pi )
        }



    }
}