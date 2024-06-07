package com.o5appstudio.androidconcepts.quizapp.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.quizapp.activities.QuestionActivity
import com.o5appstudio.androidconcepts.quizapp.models.Quiz
import com.o5appstudio.androidconcepts.quizapp.utils.ColorPicker
import com.o5appstudio.androidconcepts.quizapp.utils.IconPicker
import com.o5appstudio.androidconcepts.repository.Repositories
import java.util.zip.Inflater

class QuizAdapter(val context: Context, private val quiz: List<Quiz>) : Adapter<QuizAdapter.QuizViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent,false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.quizTitle.text = quiz[position].title
        holder.quizCardView.setBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.quizImage.setImageResource(IconPicker.getIcons())
        holder.quizCardView.setOnClickListener{
            Toast.makeText(context,holder.quizTitle.text.toString(),Toast.LENGTH_SHORT).show()
//            Repositories().simpleNavigate(context, QuestionActivity::class.java)
            val intent = Intent(context, QuestionActivity::class.java)
            intent.putExtra("DATE",quiz[position].title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return quiz.size
    }


    inner class QuizViewHolder(itemView: View) : ViewHolder(itemView){

        var quizTitle : TextView = itemView.findViewById(R.id.quizTitle)
        var quizCardView : CardView = itemView.findViewById(R.id.quizCardContainer)
        var quizImage : ImageView = itemView.findViewById(R.id.quizImage)



    }

}