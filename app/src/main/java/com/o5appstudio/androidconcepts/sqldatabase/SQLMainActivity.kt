package com.o5appstudio.androidconcepts.sqldatabase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class SQLMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_main)

        val dbHelper = DBHelper(this)
        //Add data To DB
//        dbHelper.addContact("Zain","03425956300")
//        dbHelper.addContact("Tawakal","03365956300")
//        dbHelper.addContact("Sharjeel","03036028440")
//        dbHelper.addContact("Irfan","03357512146")

        //Update data To DB
//        val model = ContactModel()
//        model.id = 1
//        model.name = "zain"
//        model.phone = "123456"
//
//        dbHelper.updateContact(model)\

        //Delete data From DB
        val idToDelete = 2 // Specify the ID of the record you want to delete
        val isDeleted = dbHelper.deleteContact(idToDelete)
        if (isDeleted) {
            // Handle successful deletion
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Not Deleted", Toast.LENGTH_SHORT).show()
            // Handle deletion failure
        }

        val arrContact: ArrayList<ContactModel> = dbHelper.fetchContacts()

        for(i in 0 until  arrContact.size){

            Log.d("Contact Info","Name : ${arrContact[i].name} Contact : ${arrContact[i].phone}")

        }

    }
}