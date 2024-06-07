package com.o5appstudio.androidconcepts.roomdatabase

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class RoomDatabaseMainActivity : AppCompatActivity() {
    private lateinit var expTitle: EditText
    private lateinit var expAmount: EditText
    private lateinit var expInsert: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database_main)
        expTitle = findViewById(R.id.expenseTitle)
        expAmount = findViewById(R.id.expenseAmount)
        expInsert = findViewById(R.id.insertExpense)
        val dbHelper = RoomHelper.getDb(this);

        expInsert.setOnClickListener{
            val title = expTitle.text.toString()
            val amount = expAmount.text.toString()

                dbHelper.expenseDao().insertData(Expe(title,amount))
                val arrExpense: List<Expe?>? =  dbHelper.expenseDao().allExpense
                if (arrExpense != null) {
                    for(i in arrExpense.indices){
                        Log.d("Expense Data", "Title : ${arrExpense[i]?.title} Amount : ${arrExpense[i]?.amount}")
                    }
                }

        }


    }
}