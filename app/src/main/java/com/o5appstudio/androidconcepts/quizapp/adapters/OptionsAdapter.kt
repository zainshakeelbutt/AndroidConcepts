package com.o5appstudio.androidconcepts.quizapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.quizapp.models.Questions

class OptionsAdapter(val context: Context, private val questions : Questions) :
    Adapter<OptionsAdapter.OptionsViewHolder>() {


        private  var options = listOf(questions.option1, questions.option2, questions.option3, questions.option4)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.question_options_item, parent, false)
        return  OptionsViewHolder(view)
    }



    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        holder.quizOption.text = options[position]
        holder.itemView.setOnClickListener{
            questions.userAnswer = options[position]
            notifyDataSetChanged()
        }
        if(questions.userAnswer == options[position]){
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        } else{
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)

        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class OptionsViewHolder(itemView: View) : ViewHolder(itemView){

        val quizOption: TextView = itemView.findViewById(R.id.quizOption)


    }
}