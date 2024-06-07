package com.o5appstudio.androidconcepts.recyclerview

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.o5appstudio.androidconcepts.R

class RecyclerViewActivity : AppCompatActivity() {
    private var arrContact = ArrayList<ContactModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewContact)

        val  floatingButton : FloatingActionButton = findViewById(R.id.btnDialog)

        recyclerView.layoutManager = LinearLayoutManager(this)

        arrContact.add(ContactModel(R.drawable.zain,"Zain","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Tawakal","45678"))
        arrContact.add(ContactModel(R.drawable.zain,"Sharjeel","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Irfan","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Zain","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Tawakal","45678"))
        arrContact.add(ContactModel(R.drawable.zain,"Sharjeel","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Irfan","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Zain","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Tawakal","45678"))
        arrContact.add(ContactModel(R.drawable.zain,"Sharjeel","123456"))
        arrContact.add(ContactModel(R.drawable.zain,"Irfan","123456"))

        val contactAdapter = RecyclerContactAdapter(this, arrContact)
        recyclerView.adapter = contactAdapter

        floatingButton.setOnClickListener {

            val dialog = Dialog(this)
            dialog.setContentView(R.layout.add_update_layout)
            val edtName = dialog.findViewById<EditText>(R.id.editName)
            val edtNumber = dialog.findViewById<EditText>(R.id.editNumber)
            val addBtn = dialog.findViewById<Button>(R.id.addBtn)
            val updateBtn = dialog.findViewById<Button>(R.id.updateBtn)
            updateBtn.visibility = View.INVISIBLE


            addBtn.setOnClickListener{

                var name = ""
                var number = ""

                if(!edtName.text.equals("")){
                    name = edtName.text.toString()
                } else {
                    Toast.makeText(this,"Enter Name",Toast.LENGTH_SHORT).show()
                }

                if(!edtNumber.text.equals("")){
                    number = edtNumber.text.toString()
                } else {
                    Toast.makeText(this,"Enter Number",Toast.LENGTH_SHORT).show()
                }
                if(!edtName.text.equals("") && !edtNumber.text.equals("")){
                    arrContact.add(ContactModel(R.drawable.zain, name,number))
                    contactAdapter.notifyItemInserted(arrContact.size-1)
                    recyclerView.scrollToPosition(arrContact.size-1)
                }
                dialog.dismiss()

            }

            updateBtn.setOnClickListener{

            }
            dialog.show()

        }


    }
}

//Java Code for Adapters

//public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
//
//    Context context;
//    ArrayList<ContactModel> arrContact;
//    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact){
//        this.context = context;
//        this.arrContact = arrContact;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.contact_card, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        holder.image.setImageURI(Uri.parse(arrContact.get(position).image));
//        holder.name.setText(arrContact.get(position).name);
//        holder.number.setText(arrContact.get(position).number);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return arrContact.size();
//    }
//
//    public static class  ViewHolder extends  RecyclerView.ViewHolder{
//
//        ImageView image;
//        TextView  name, number;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            image = itemView.findViewById(R.id.contactImage);
//            name = itemView.findViewById(R.id.contactName);
//            number = itemView.findViewById(R.id.contactNumber);
//        }
//    }
//
//}