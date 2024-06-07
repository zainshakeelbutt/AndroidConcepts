package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model.Users
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model.UsersItem

class UsersAdapter(val context: Context, private val usersList : ArrayList<UsersItem>) : Adapter<UsersAdapter.UsersViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.users_item_view,parent,false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = usersList[position]
        holder.name.text = user.name
        holder.usersName.text = user.username
        holder.email.text = user.email
        holder.phone.text = user.phone
        holder.website.text = user.website
        holder.street.text = user.address.street
        holder.city.text = user.address.city
        holder.zip.text = user.address.zipcode
        holder.lat.text = user.address.geo.lat
        holder.lng.text = user.address.geo.lng
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class UsersViewHolder(itemView: View) : ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.uName)
        val usersName: TextView = itemView.findViewById(R.id.usersName)
        val email: TextView = itemView.findViewById(R.id.email)
        val phone: TextView = itemView.findViewById(R.id.phone)
        val website: TextView = itemView.findViewById(R.id.website)
        val street: TextView = itemView.findViewById(R.id.street)
        val city: TextView = itemView.findViewById(R.id.city)
        val zip: TextView = itemView.findViewById(R.id.zip)
        val lat: TextView = itemView.findViewById(R.id.lat)
        val lng: TextView = itemView.findViewById(R.id.lng)

    }

    fun updateUsers(newUsers:  ArrayList<UsersItem>){
        usersList.clear()
        usersList.addAll(newUsers)
        notifyDataSetChanged()
    }

}