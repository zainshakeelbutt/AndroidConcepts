package com.o5appstudio.androidconcepts.recyclerview

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.compose.animation.core.Animation
import androidx.recyclerview.widget.RecyclerView
import com.o5appstudio.androidconcepts.R

class RecyclerContactAdapter internal constructor(var context: Context, private var arrContact: ArrayList<ContactModel>) :
    RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(arrContact[position].image)
        holder.name.text = arrContact[position].name
        holder.number.text = arrContact[position].number
        holder.rowLayout.setOnClickListener{
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.add_update_layout)

            val edtName = dialog.findViewById<EditText>(R.id.editName)
            val edtNumber = dialog.findViewById<EditText>(R.id.editNumber)
            val addBtn = dialog.findViewById<Button>(R.id.addBtn)
            val updateBtn = dialog.findViewById<Button>(R.id.updateBtn)
            addBtn.visibility = View.INVISIBLE

            edtName.setText(arrContact[position].name)
            edtNumber.setText(arrContact[position].number)

            updateBtn.setOnClickListener{
                var name = ""
                var number = ""

                if(!edtName.text.equals("")){
                    name = edtName.text.toString()
                } else {
                    Toast.makeText(context,"Enter Name", Toast.LENGTH_SHORT).show()
                }

                if(!edtNumber.text.equals("")){
                    number = edtNumber.text.toString()
                } else {
                    Toast.makeText(context,"Enter Number", Toast.LENGTH_SHORT).show()
                }

                if(!edtName.text.equals("") && !edtNumber.text.equals("")){
                    arrContact[position] = ContactModel(R.drawable.zain, name,number)
                    notifyItemChanged(position)
                    dialog.dismiss()
                }


            }

            dialog.show()
        }
        setAnimation(holder.itemView, position)
        holder.rowLayout.setOnLongClickListener {
            AlertDialog.Builder(context)
                .setTitle("Delete Contact")
                .setMessage("Do You Want to Delete?")
                .setIcon(android.R.drawable.ic_menu_delete)
                .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                    arrContact.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("No") {dialogInterface: DialogInterface, i: Int ->

                }
                .show()
            true
        }
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.contactImage)
        var name: TextView = itemView.findViewById(R.id.contactName)
        var number: TextView = itemView.findViewById(R.id.contactNumber)
        var rowLayout : LinearLayout = itemView.findViewById(R.id.rootLinearLayout)
    }

    var lastPosition = -1

    private fun setAnimation(view: View, position: Int){
        if(position>lastPosition){
            val slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            view.startAnimation(slideIn)
            lastPosition = position
        }

    }
}