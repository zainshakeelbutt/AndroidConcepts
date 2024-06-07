package com.o5appstudio.androidconcepts.fragments.dynamicfragments

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.fragments.AFragment
import com.o5appstudio.androidconcepts.fragments.BFragment
import com.o5appstudio.androidconcepts.fragments.CFragment

class DynamicFragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragments)

        val btnOne : Button = findViewById(R.id.btnOne)
        val btnTwo : Button = findViewById(R.id.btnTwo)
        val btnThree : Button = findViewById(R.id.btnThree)

        // default container
        loadFragment(AFragment(),0)


        btnOne.setOnClickListener{
            loadFragment(AFragment().getInstance("Zain BUtt",40),1)
        }

        btnTwo.setOnClickListener{
            loadFragment(BFragment(),1)
        }

        btnThree.setOnClickListener{
            loadFragment(CFragment(),1)
        }

    }

    private fun loadFragment(fragment: Fragment, flag:Int){
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
//        val bundle = Bundle()
//        bundle.putString("arg1","Zain")
//        bundle.putInt("arg2",30)
//        fragment.arguments = bundle

        if (flag == 0){
            ft.add(R.id.container, fragment)
//            fm.popBackStack("ROOT_FRAGRMENT_TAG", FragmentManager.POP_BACK_STACK_INCLUSIVE)
//            ft.addToBackStack("ROOT_FRAGRMENT_TAG")
        }
        else {
            ft.replace(R.id.container, fragment)
            ft.addToBackStack(null)

        }
        ft.commit()
    }

    fun callFromFragment(){
        Log.d("In Activity","From Fragment")
    }

}