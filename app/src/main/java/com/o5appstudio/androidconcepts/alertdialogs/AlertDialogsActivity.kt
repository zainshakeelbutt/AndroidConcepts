package com.o5appstudio.androidconcepts.alertdialogs

import android.app.Dialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class AlertDialogsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialogs)

        val singleBtnDialog : Button = findViewById(R.id.singleButtonDialogBtn)
        val twoBtnDialog : Button = findViewById(R.id.twoButtonDialogBtn)
        val customDialog : Button = findViewById(R.id.customDialogBtn)

        singleBtnDialog.setOnClickListener {
            singleButtonAlertDialog()
        }
        twoBtnDialog.setOnClickListener {
            deleteDialog()
        }

        customDialog.setOnClickListener {
            customDialog("Success", "You have successfully placed the order!")
        }


    }

    private fun singleButtonAlertDialog(){

        val alertDialog = AlertDialog.Builder(this).create()

        alertDialog.setTitle("Terms & Conditions")
        alertDialog.setIcon(android.R.drawable.ic_dialog_alert)
        alertDialog.setMessage("Have you read All Terms and Conditions?")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "yes i've read!") { _, _ ->
            // Do something when the OK button is clicked
            Toast.makeText(applicationContext, "OK clicked", Toast.LENGTH_SHORT).show()
        }
        alertDialog.show()

    }

    private fun deleteDialog(){

        val deleteDialog = AlertDialog.Builder(this)

        deleteDialog.setTitle("Delete")
        deleteDialog.setIcon(android.R.drawable.ic_delete)
        deleteDialog.setMessage("Do you want to delete?")
        deleteDialog.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(applicationContext, "Deleted", Toast.LENGTH_SHORT).show()
        }
        deleteDialog.setNegativeButton("No") { _, _ ->
            Toast.makeText(applicationContext, "Not Deleted", Toast.LENGTH_SHORT).show()
        }

        deleteDialog.show()

    }


    private fun customDialog(title: String, desc: String){
        var customDialog = Dialog(this)
        val View = layoutInflater.inflate(R.layout.custom_dialog_layout, findViewById(R.id.customDialogLinearLayout))
        customDialog.setContentView(R.layout.custom_dialog_layout)
        val titleText : TextView = customDialog.findViewById(R.id.customDialogTitleTextView)
        val descText : TextView = customDialog.findViewById(R.id.customDialogDescTextView)
        val okayBtn : Button = customDialog.findViewById(R.id.customDialogDismissBtn)

        customDialog.setCancelable(false)
        titleText.text = title
        descText.text = desc
        okayBtn.setOnClickListener{
            customDialog.dismiss()
        }

        customDialog.show()

    }



    override fun onBackPressed() {
        val exitDialog = AlertDialog.Builder(this)

        exitDialog.setTitle("Exit")
        exitDialog.setIcon(android.R.drawable.ic_menu_close_clear_cancel)
        exitDialog.setMessage("Do you want to Exit?")
        exitDialog.setPositiveButton("Yes") { _, _ ->
            super.onBackPressedDispatcher.onBackPressed()
        }
        exitDialog.setNegativeButton("No") { _, _ ->
            Toast.makeText(applicationContext, "Not Exit", Toast.LENGTH_SHORT).show()
        }
        exitDialog.setNeutralButton("Cancel") { _, _ ->
            Toast.makeText(applicationContext, "Cancel", Toast.LENGTH_SHORT).show()
        }

        exitDialog.show()

    }

}