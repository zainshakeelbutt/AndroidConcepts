package com.o5appstudio.androidconcepts.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.quizapp.adapters.OptionsAdapter
import com.o5appstudio.androidconcepts.quizapp.models.Questions
import com.o5appstudio.androidconcepts.quizapp.models.Quiz

class QuestionActivity : AppCompatActivity() {
    lateinit var qDescription : TextView
    lateinit var questionsList : RecyclerView
    lateinit var firestore: FirebaseFirestore
    lateinit var btnPrev: Button
    lateinit var btnNext: Button
    lateinit var btnSubmit: Button
    var quizzes : MutableList<Quiz>? = null
    var questions : MutableMap<String, Questions>? = null
    var index = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        qDescription = findViewById(R.id.qDescription)
        questionsList = findViewById(R.id.questionsList)
        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        btnSubmit = findViewById(R.id.btnSubmit)
        setupFirestore()
        setUpEventsListeners()

    }

    private fun setUpEventsListeners() {
        btnPrev.setOnClickListener {
            index--
            bindView()
        }
        btnNext.setOnClickListener {
            index++
            bindView()
        }
        btnSubmit.setOnClickListener {
            val iIntent = Intent(this, QuizResultActivity::class.java)
            val json = Gson().toJson(quizzes!![0])
            iIntent.putExtra("QUIZ", json)
            startActivity(iIntent)
        }
    }

    private fun setupFirestore() {
        firestore = FirebaseFirestore.getInstance()
        val date = intent.getStringExtra("DATE")
        if(date != null){
            firestore.collection("quizzes").whereEqualTo("title",date)
                .get()
                .addOnSuccessListener {

                    if(it != null && !it.isEmpty){
                        quizzes = it.toObjects(Quiz::class.java)
                        questions  = quizzes!![0].questions
                        bindView()
                    }

                }
        }


    }

    private fun bindView() {

        btnPrev.visibility = View.GONE
        btnNext.visibility = View.GONE
        btnSubmit.visibility = View.GONE

        if(index == 1){
            btnNext.visibility = View.VISIBLE
        } else if(index == questions!!.size){
            btnPrev.visibility = View.VISIBLE
            btnNext.visibility = View.GONE
            btnSubmit.visibility = View.VISIBLE
        } else{
            btnPrev.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE
            btnSubmit.visibility = View.GONE
        }

        val questions = questions!!["question$index"]

        questions?.let {
            qDescription.text = it.description
            val optionAdapter =  OptionsAdapter(this, it)
            questionsList.layoutManager = LinearLayoutManager(this)
            questionsList.adapter = optionAdapter
            questionsList.setHasFixedSize(true)
        }





    }
}