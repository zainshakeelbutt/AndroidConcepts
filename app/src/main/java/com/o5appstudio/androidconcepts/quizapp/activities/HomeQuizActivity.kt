package com.o5appstudio.androidconcepts.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.material3.DatePicker
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.quizapp.adapters.QuizAdapter
import com.o5appstudio.androidconcepts.quizapp.models.Quiz
import com.o5appstudio.androidconcepts.repository.Repositories
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

class HomeQuizActivity : AppCompatActivity() {
    lateinit var adapter: QuizAdapter
    lateinit var drawerLayout: DrawerLayout
    lateinit var drawerNavView: NavigationView
    lateinit var drawerToolbar: Toolbar
    lateinit var quizListRecycler : RecyclerView
    lateinit var datePicker : FloatingActionButton

    lateinit var firestore: FirebaseFirestore
    lateinit var date : String

    private var quizList = mutableListOf<Quiz>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_home)
        drawerLayout = findViewById(R.id.quizDrawerLayout)
        drawerNavView  = findViewById(R.id.quizDrawerNavView)
        drawerToolbar = findViewById(R.id.quizToolbar)
        quizListRecycler = findViewById(R.id.quizListRecycler)
        datePicker = findViewById(R.id.btnDatePicker)
        setupFirestore()
        setupViews()
        setupDatePicker()

    }

    private fun setupDatePicker() {
        datePicker.setOnClickListener {
            val pickDate = MaterialDatePicker.Builder.datePicker().build()
            pickDate.show(supportFragmentManager,"DatePicker")
            pickDate.addOnPositiveButtonClickListener {
                val dateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.US)
                date = dateFormat.format(Date(it))
                Log.d("Date Picker",date)
                getQuizzesByDate()
            }
            pickDate.addOnNegativeButtonClickListener {
                Log.d("Date Picker",pickDate.headerText)
            }
            pickDate.addOnCancelListener {
                Log.d("Date Picker","Date Picker cancelled")
            }
        }
    }

    private fun getQuizzesByDate() {
        firestore  = FirebaseFirestore.getInstance()
        val collectionRef = firestore.collection("quizzes").whereEqualTo("title",date)
        collectionRef.addSnapshotListener { value, error ->
            if(value == null || error != null){
                Toast.makeText(this, "Error fetching Data", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            else{
                quizList.clear()
                quizList.addAll(value.toObjects(Quiz::class.java))
                adapter.notifyDataSetChanged()
            }

        }
    }

    private fun setupFirestore() {
        firestore  = FirebaseFirestore.getInstance()
        val collectionRef = firestore.collection("quizzes")
        collectionRef.addSnapshotListener { value, error ->
            if(value == null || error != null){
                Toast.makeText(this, "Error fetching Data", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            else{
                quizList.clear()
                quizList.addAll(value.toObjects(Quiz::class.java))
                adapter.notifyDataSetChanged()
            }

        }
    }

//    private fun popDummyData() {
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//        quizList.add(Quiz("12-10-21","12-10-21"))
//    }

    private fun setupViews() {
        setupDrawerLayout()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = QuizAdapter(this, quizList)
        quizListRecycler.layoutManager = GridLayoutManager(this, 2)
        quizListRecycler.adapter = adapter
    }

    private fun setupDrawerLayout() {
        setSupportActionBar(drawerToolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, drawerToolbar, R.string.openDrawer, R.string.closeDrawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val settingQuiz : LinearLayout = findViewById(R.id.settingQuiz)
        val logoutQuiz : LinearLayout = findViewById(R.id.logoutQuiz)
        settingQuiz.setOnClickListener{
           Repositories().simpleNavigate(this, ProfileActivity::class.java)
        }

        logoutQuiz.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginQuizActivity::class.java)
            startActivity(intent)
            finish()
        }


    }



}