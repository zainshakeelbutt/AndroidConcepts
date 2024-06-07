package com.o5appstudio.androidconcepts.navigationdrawer

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.fragments.AFragment
import com.o5appstudio.androidconcepts.fragments.BFragment
import com.o5appstudio.androidconcepts.fragments.CFragment

class NavigationDrawerActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        drawerLayout = findViewById(R.id.drawerLayout)
        val drawerNavView : NavigationView = findViewById(R.id.drawerNavView)
        val drawerToolbar : Toolbar = findViewById(R.id.drawerToolBar)



        //Step 1
        setSupportActionBar(drawerToolbar)
        // Step 2
        val toggle = ActionBarDrawerToggle(this, drawerLayout, drawerToolbar, R.string.openDrawer, R.string.closeDrawer)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        loadFragment(AFragment(),0)

        drawerNavView.setNavigationItemSelectedListener {item ->
            val id = item.itemId
            if (id == R.id.drawerNotes){
                loadFragment(AFragment(),1)
            }
            else if (id == R.id.drawerCategories){
                loadFragment(BFragment(),1)
            }
            else {
                loadFragment(CFragment(),1)
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }


    }

    override fun onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }



    private fun loadFragment(fragment: Fragment, flag: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        if(flag == 0){
            ft.add(R.id.drawerFrameMain, fragment)
        } else {
            ft.replace(R.id.drawerFrameMain, fragment)
        }
        ft.commit()
    }
}