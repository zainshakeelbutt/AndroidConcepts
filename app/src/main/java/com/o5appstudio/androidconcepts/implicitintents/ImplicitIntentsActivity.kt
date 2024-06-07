package com.o5appstudio.androidconcepts.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)

        val dialerBtn : Button = findViewById(R.id.dialerBtn)
        val messageBtn : Button = findViewById(R.id.msgBtn)
        val emailBtn : Button = findViewById(R.id.emailBtn)
        val shareBtn : Button = findViewById(R.id.shareBtn)

        dialerBtn.setOnClickListener{

            val iDial = Intent(Intent.ACTION_DIAL)
            iDial.setData(Uri.parse("tel: +923425956300"))
            startActivity(iDial)
        }

        messageBtn.setOnClickListener{
            val iMsg = Intent(Intent.ACTION_SENDTO)
            iMsg.setData(Uri.parse("smsto:"+Uri.encode("+923425956300")))
            iMsg.putExtra("sms_body","Please resolve the issue asap")
            startActivity(iMsg)
        }

        emailBtn.setOnClickListener{
            val iEmail = Intent(Intent.ACTION_SEND)
            iEmail.setType("message/rfc822")
            iEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("zain.butt92@gmail.com","zainshakeel300@gmail.com"))
            iEmail.putExtra(Intent.EXTRA_SUBJECT,"My Mail")
            iEmail.putExtra(Intent.EXTRA_TEXT,"Hello This is me")
            startActivity(Intent.createChooser(iEmail,"Email Via"))
        }

        shareBtn.setOnClickListener{
            val iShare = Intent(Intent.ACTION_SEND)
            iShare.setType("text/plain")
            iShare.putExtra(Intent.EXTRA_TEXT,"Hello This is me")
            startActivity(Intent.createChooser(iShare,"Share Via"))
        }


    }
}