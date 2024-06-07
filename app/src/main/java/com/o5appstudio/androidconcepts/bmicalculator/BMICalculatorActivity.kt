package com.o5appstudio.androidconcepts.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class BMICalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmicalculator)
        val edtWeight = findViewById<EditText>(R.id.edtWeight)
        val edtHeightFt = findViewById<EditText>(R.id.edtHeightFt)
        val edtHeightIn = findViewById<EditText>(R.id.edtHeightIn)
        val btnCalculate = findViewById<Button>(R.id.calculateBtn)
        val txtResult = findViewById<TextView>(R.id.result)
        val linLayout = findViewById<LinearLayout>(R.id.linearLayout)

        btnCalculate.setOnClickListener {

            if(edtWeight.text.toString() != "" && edtHeightFt.text.toString() != "" && edtHeightIn.text.toString() != ""){
                val wt = edtWeight.text.toString().toInt()
                val hFt = edtHeightFt.text.toString().toInt()
                val hIn = edtHeightIn.text.toString().toInt()

                val totalInches = hFt * 12 + hIn
                val totalCm = totalInches * 2.53
                val totalM = totalCm / 100
                val bmi = wt / (totalM * totalM)

                if (bmi > 25) {
                    txtResult.setText(R.string.over_weight)
                    linLayout.setBackgroundColor(resources.getColor(R.color.overWeight,resources.newTheme()))
                } else if (bmi < 18) {
                    txtResult.setText(R.string.under_weight)
                    linLayout.setBackgroundColor(resources.getColor(R.color.underWeight,resources.newTheme()))
                } else {
                    txtResult.setText(R.string.healthy)
                    linLayout.setBackgroundColor(resources.getColor(R.color.healthy, resources.newTheme()))

                }
            }

        }

    }
}