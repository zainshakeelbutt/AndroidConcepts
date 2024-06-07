package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model.AlbumList
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model.AlbumListItem
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository.AlbumResponse

class AlbumAdapter(val context: Context, private val albumList: ArrayList<AlbumListItem>) : Adapter<AlbumAdapter.AlbumViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.albumb_item_view, parent, false)
        return AlbumViewHolder(view)
    }



    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.albumId.text =album.id.toString()
        holder.albumTitle.text = album.title
        holder.albumUrl.text = album.url
        Glide.with(context).load(album.thumbnailUrl).into(holder.albumImage)
    }

    override fun getItemCount(): Int {
        return  albumList.size
    }

    fun updateAlbum(newList: AlbumList) {
        albumList.clear()
        albumList.addAll(newList)
        notifyDataSetChanged()
    }

    class AlbumViewHolder(itemView: View) : ViewHolder(itemView){
        val albumImage : ImageView = itemView.findViewById(R.id.thumbnailUrl)
        val albumId : TextView = itemView.findViewById(R.id.albumId)
        val albumTitle : TextView = itemView.findViewById(R.id.albumTitle)
        val albumUrl : TextView = itemView.findViewById(R.id.albumUrl)

    }
}

