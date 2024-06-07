package com.o5appstudio.androidconcepts.notifications

import NotificationHelper
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.listviews.ListViewActivity
import com.o5appstudio.androidconcepts.splash.SplashActivity

class NotificationsActivity : AppCompatActivity() {
    private var channelID = "My Channel"
    private var channelname = "My Channel"
    private var notificationID = 100
    private var requestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.user, null)
        val bitmapDrawable: BitmapDrawable = drawable as BitmapDrawable
        val largeIcon = bitmapDrawable.bitmap
        val notifButton:Button = findViewById(R.id.notifBtn)

        val notification:Notification
        val channel = NotificationChannel(channelID,channelname, NotificationManager.IMPORTANCE_HIGH)
        val nm =  getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val intentActivity = Intent(applicationContext, SplashActivity::class.java)
        intentActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pIntent = PendingIntent.getActivity(this,requestCode,intentActivity, PendingIntent.FLAG_MUTABLE)

        //Big picture Stye

        val bigPicStyle = Notification.BigPictureStyle().bigPicture((ResourcesCompat.getDrawable(resources, R.drawable.user, null) as BitmapDrawable).bitmap ).bigLargeIcon(largeIcon).setBigContentTitle("Image Sent by Zain").setSummaryText("Image Message")

        //Inbox Style

        val inboxStyle = Notification.InboxStyle()
            .addLine("A")
            .addLine("B")
            .addLine("C")
            .addLine("D")
            .addLine("E")
            .addLine("F")
            .addLine("G")
            .addLine("H")
            .addLine("I")
            .addLine("J")
            .addLine("K")
            .setBigContentTitle("Full Message")
            .setSummaryText("Message from me")


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notification = Notification.Builder(this,channelID)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.user)
                .setContentText("New Message")
                .setSubText("This is Notification Message")
                .setChannelId(channelID)
                .setAutoCancel(false)
                .setOngoing(true)
                .setStyle(bigPicStyle)
                .setContentIntent(pIntent)
                .build()
        } else{
            notification = Notification.Builder(this,channelID)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.user)
                .setContentText("New Message")
                .setSubText("This is Notification Message")
                .setStyle(bigPicStyle)
                .setAutoCancel(false)
                .setOngoing(true)
                .setContentIntent(pIntent)

                .build()
        }

        nm.createNotificationChannel(NotificationChannel(channelID,"New Channel", NotificationManager.IMPORTANCE_HIGH))
        notifButton.setOnClickListener{
            nm.notify(notificationID,notification)

        }


    }
}