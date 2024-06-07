package com.o5appstudio.androidconcepts.listviews

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class ListViewActivity : AppCompatActivity() {
    private lateinit var listView : ListView
    private lateinit var proofTv : TextView
    private lateinit var spinner : Spinner
    private lateinit var autoCompleteTv : AutoCompleteTextView

    private lateinit var arrNames : ArrayList<String>
    private lateinit var arrProof : ArrayList<String>
    private lateinit var arrLanguage : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        supportActionBar?.title = "Lists"
        listView = findViewById(R.id.listView)

        arrNames = ArrayList()
        arrNames.add("Zain")
        arrNames.add("Ali")
        arrNames.add("Sharjeel")
        arrNames.add("Tawakal")
        arrNames.add("Irfan")
        arrNames.add("Zain")
        arrNames.add("Ali")
        arrNames.add("Sharjeel")
        arrNames.add("Tawakal")
        arrNames.add("Irfan")
        arrNames.add("Zain")
        arrNames.add("Ali")
        arrNames.add("Sharjeel")
        arrNames.add("Tawakal")
        arrNames.add("Irfan")
        arrNames.add("Zain")
        arrNames.add("Ali")
        arrNames.add("Sharjeel")
        arrNames.add("Tawakal")
        arrNames.add("Irfan")
        arrNames.add("Zain")
        arrNames.add("Ali")
        arrNames.add("Sharjeel")
        arrNames.add("Tawakal")
        arrNames.add("Irfan")

        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, arrNames)
        listView.adapter = arrAdapter

        listView.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Name is ${arrNames[position]}", Toast.LENGTH_SHORT).show()
        }

        //Spinner Section

        proofTv = findViewById(R.id.idProofTv)
        spinner = findViewById(R.id.proofSpinner)
        arrProof = ArrayList()

        arrProof.add("ID")
        arrProof.add("Passport")
        arrProof.add("CNIC")
        arrProof.add("Driving License")
        arrProof.add("Other")

        val proofArrAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrProof)
        proofArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = proofArrAdapter
        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //  Autocomplete Text Section

        autoCompleteTv  = findViewById(R.id.autoCompleteTv)
        arrLanguage = ArrayList()
        arrLanguage.add("C")
        arrLanguage.add("C++")
        arrLanguage.add("Objective C")
        arrLanguage.add("Dart")
        arrLanguage.add("Java")
        arrLanguage.add("Visual Basic")
        arrLanguage.add("Assembly")
        arrLanguage.add("Swift")

        val arrLanguageAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, arrLanguage)

        autoCompleteTv.setAdapter(arrLanguageAdapter)
        autoCompleteTv.threshold = 1






    }
}