package com.o5appstudio.androidconcepts.newsapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.o5appstudio.androidconcepts.R

class NewsAdapter(val context : Context, val articles: List<Atricles>) : Adapter<NewsAdapter.ArticlesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.news_item_view,parent,false)
        return ArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val articles : Atricles = articles[position]
        holder.newsTitle.text = articles.title
        holder.newsDesc.text = articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener{
            val iIntent = Intent(context, DetailActivity::class.java)
            iIntent.putExtra("url",articles.url)
            context.startActivity(iIntent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticlesViewHolder(itemView: View) : ViewHolder(itemView){
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDesc = itemView.findViewById<TextView>(R.id.newsDescription)
        var newsImage= itemView.findViewById<ImageView>(R.id.newsImage)
        var container = itemView.findViewById<LinearLayout>(R.id.container)
    }

}

