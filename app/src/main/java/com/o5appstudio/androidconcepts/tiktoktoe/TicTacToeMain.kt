package com.o5appstudio.androidconcepts.tiktoktoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class TicTacToeMain : AppCompatActivity() {
    private var flag = 0
    private var counter = 0
    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private lateinit var btn7 : Button
    private lateinit var btn8 : Button
    private lateinit var btn9 : Button
    private lateinit var b1 : String
    private lateinit var b2 : String
    private lateinit var b3 : String
    private lateinit var b4 : String
    private lateinit var b5 : String
    private lateinit var b6 : String
    private lateinit var b7 : String
    private lateinit var b8 : String
    private lateinit var b9 : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tic_tac_toe_main)
        init()
    }

     private fun init() : Unit {
        btn1 = findViewById(R.id.btn1)
        btn2  = findViewById(R.id.btn2)
        btn3  = findViewById(R.id.btn3)
        btn4  = findViewById(R.id.btn4)
        btn5  = findViewById(R.id.btn5)
        btn6  = findViewById(R.id.btn6)
        btn7  = findViewById(R.id.btn7)
        btn8  = findViewById(R.id.btn8)
        btn9  = findViewById(R.id.btn9)
    }

    fun check(view: View){
        val btnCurrent : Button = view as Button
        if(btnCurrent.text.toString() == ""){
            counter++
            if(flag==0) {
                btnCurrent.text = "X"
                flag = 1
            } else {
                btnCurrent.text = "O"
                flag = 0
            }

            if(counter >4){
                b1 = btn1.text.toString()
                b2 = btn2.text.toString()
                b3 = btn3.text.toString()
                b4 = btn4.text.toString()
                b5 = btn5.text.toString()
                b6 = btn6.text.toString()
                b7 = btn7.text.toString()
                b8 = btn8.text.toString()
                b9 = btn9.text.toString()

                //Conditions

                if(b1 == b2 && b2 == b3 && b1 != ""){
                    Toast.makeText(this, "Winner is : $b1", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //1
                } else if(b4 == b5 && b5 == b6 && b4 != ""){
                    Toast.makeText(this, "Winner is : $b4", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //2
                } else if(b7 == b8 && b8 == b9 && b7 != ""){
                    Toast.makeText(this, "Winner is : $b7", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //3
                } else if(b1 == b4 && b4 == b7 && b1 != ""){
                    Toast.makeText(this, "Winner is : $b1", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //4
                } else if(b2 == b5 && b5 == b8 && b2 != ""){
                    Toast.makeText(this, "Winner is : $b2", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //5
                } else if(b3 == b6 && b6 == b9 && b3 != ""){
                    Toast.makeText(this, "Winner is : $b3", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //6
                } else if(b1 == b5 && b5 == b9 && b1 != ""){
                    Toast.makeText(this, "Winner is : $b1", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //7
                } else if(b3 == b5 && b5 == b7 && b3 != ""){
                    Toast.makeText(this, "Winner is : $b3", Toast.LENGTH_SHORT).show()
                    reStartGame()
                    //8
                } else if( counter == 9){
                    Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
                    reStartGame()
                }


            }
        }

    }

    fun reStartGame() : Unit{
         btn1.text = ""
         btn2.text = ""
         btn3.text = ""
         btn4.text = ""
         btn5.text = ""
         btn6.text = ""
         btn7.text = ""
         btn8.text = ""
         btn9.text = ""
        counter = 0
        flag = 0
    }



}