package com.o5appstudio.androidconcepts.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.fragments.AFragment
import com.o5appstudio.androidconcepts.fragments.BFragment
import com.o5appstudio.androidconcepts.fragments.CFragment

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNav)

        bottomNav.setOnNavigationItemSelectedListener {item ->
            val id = item.itemId
            if (id == R.id.navHome){
                loadFragment(AFragment(),1)
            }
            else if (id == R.id.navContact){
                loadFragment(BFragment(),1)
            }
            else if (id == R.id.navProfile){
                loadFragment(CFragment(),1)
            }
            else if (id == R.id.navPortfolio){
                loadFragment(AFragment(),1)
            }
            else {
                loadFragment(BFragment(),1)
            }

        }

        bottomNav.selectedItemId = R.id.navHome

    }

    private fun loadFragment(fragment: Fragment, flag: Int): Boolean {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        if(flag == 0){
            ft.add(R.id.bottomNavFrame, fragment)
        } else {
            ft.replace(R.id.bottomNavFrame, fragment)
        }
        ft.commit()
        return true

    }

}