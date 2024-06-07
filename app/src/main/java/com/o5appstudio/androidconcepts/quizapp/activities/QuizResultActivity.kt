package com.o5appstudio.androidconcepts.quizapp.activities

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.quizapp.models.Quiz

class QuizResultActivity : AppCompatActivity() {
    lateinit var quiz: Quiz
    lateinit var txtScore : TextView
    lateinit var txtAnswer : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)
        txtScore = findViewById(R.id.txtScore)
        txtAnswer = findViewById(R.id.txtAnswer)
        setupViews()

    }

    private fun setupViews() {
        val quizData = intent.getStringExtra("QUIZ")
        quiz = Gson().fromJson<Quiz>(quizData, Quiz::class.java)
        calculateScore()
        setAnswerView()
    }

    private fun setAnswerView() {
        val builder = StringBuilder("")
        for (entry in quiz.questions.entries) {
            val question = entry.value
            builder.append("<font color'#18206F'><b>Question: ${question.description}</b></font><br/><br/>")
            builder.append("<font color='#009688'>Answer: ${question.answer}</font><br/><br/>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            txtAnswer.text = Html.fromHtml(builder.toString(), Html.FROM_HTML_MODE_COMPACT);
        } else {
            txtAnswer.text = Html.fromHtml(builder.toString());
        }
    }

    private fun calculateScore() {
        var score = 0
        for(entry in quiz.questions.entries){
            val questions = entry.value
            if(questions.answer == questions.userAnswer){
                score += 10
            }
        }
        txtScore.text = "Your Score : $score"
    }
}