package com.o5appstudio.androidconcepts.customtoast

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Snackbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.o5appstudio.androidconcepts.R

class CustomToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_toast)

        val toastBtn : Button = findViewById(R.id.toastBtn)
        val customToastBtn : Button = findViewById(R.id.customToastBtn)
        val snackBarBtn : Button = findViewById(R.id.snackBarBtn)
        val customSnackBarBtn : Button = findViewById(R.id.customSnackBarBtn)


        toastBtn.setOnClickListener{
            Toast.makeText(this,"This is Simple Toast", Toast.LENGTH_SHORT).show()
        }
        customToastBtn.setOnClickListener{
            customToast("Hi this is Custom Toast")
        }
        snackBarBtn.setOnClickListener{
            Snackbar.make(findViewById(android.R.id.content), "This is a Snackbar", Snackbar.LENGTH_SHORT).show()
//            Snackbar.make(findViewById(android.R.id.content), "This is a sna")
        }
        customSnackBarBtn.setOnClickListener{
            customSnackBar("This is Custom Snackbar")
        }


    }
    private fun customToast(toastText:String){


        var toast = Toast(applicationContext)
        val view =layoutInflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.toastLinearLayout))

        val toastTextView = view.findViewById<TextView>(R.id.toastTextView)
        val toastImage = view.findViewById<ImageView>(R.id.toastImage)

        toastTextView.text = toastText

        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.show()


    }

    private  fun customSnackBar(snackBarText:String){
        val snackbar = Snackbar.make(findViewById(android.R.id.content), snackBarText, Snackbar.LENGTH_SHORT)

        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))

        val textView: TextView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text)
        textView.setTextColor(Color.WHITE)

        snackbar.show()

    }
}