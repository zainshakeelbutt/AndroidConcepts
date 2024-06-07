package com.o5appstudio.androidconcepts.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer!!.isLooping = true
        mediaPlayer!!.start()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        mediaPlayer!!.stop()
        super.onDestroy()
    }
}