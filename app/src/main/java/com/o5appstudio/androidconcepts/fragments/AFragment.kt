package com.o5appstudio.androidconcepts.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.fragments.dynamicfragments.DynamicFragmentsActivity


class AFragment : Fragment() {

    private val arg1 = "argument1"
    private val arg2 = "argument2"

    fun getInstance(val1:String, val2:Int) : AFragment{
        val aFragment = AFragment()
        val bundle = Bundle()
        bundle.putString(arg1,val1)
        bundle.putInt(arg2,val2)
        aFragment.arguments = bundle

        return  aFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val textFrag : TextView = view.findViewById(R.id.txtFrag1)

        if(arguments!=null){
            val name = arguments?.getString(arg1)
            val age = arguments?.getInt(arg2)
            Log.d("Values From Frags", "Name is ${name} and age is ${age.toString()}")
            (activity as DynamicFragmentsActivity).callFromFragment()

        }



        return  view
    }


}