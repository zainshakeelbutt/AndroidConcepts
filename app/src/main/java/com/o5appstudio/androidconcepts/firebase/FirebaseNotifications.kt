package com.o5appstudio.androidconcepts.firebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.notifications.NotificationsActivity

class FirebaseNotifications : FirebaseMessagingService() {

    private var notificationID = 100
    private var channelID = "My Channel"
    private var channelName = "My Channel"
    private var description = "Channel for push notifications"
    private var importance = NotificationManager.IMPORTANCE_HIGH
    private lateinit var notification: Notification

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("Refreshed Token", token)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (message.notification != null) {
            pushNotification(message.notification!!.title, message.notification!!.body)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun pushNotification(title: String?, message: String?) {

        val nm =  getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val intentActivity = Intent(applicationContext, NotificationsActivity::class.java)
        intentActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pIntent = PendingIntent.getActivity(this,100,intentActivity, PendingIntent.FLAG_MUTABLE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel(channelID,channelName,importance)
            channel.description = description

            nm.createNotificationChannel(channel)
            notification = Notification.Builder(this,channelID)
                .setSmallIcon(R.drawable.ic_done)
                .setContentText(title)
                .setSubText(message)
                .setChannelId(channelID)
                .setAutoCancel(true)
                .setOngoing(false)
                .setContentIntent(pIntent)
                .build()

        } else{
            notification = Notification.Builder(this,channelID)
                .setSmallIcon(R.drawable.ic_done)
                .setContentText(title)
                .setSubText(message)
                .setAutoCancel(true)
                .setOngoing(false)
                .setContentIntent(pIntent)
                .build()
        }

        nm.notify(notificationID,notification)

    }


}