package com.o5appstudio.androidconcepts.tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.o5appstudio.androidconcepts.R

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        val tab : TabLayout = findViewById(R.id.tabsID)
        val viewPager : ViewPager2 = findViewById(R.id.viewPagerID)

        val vpAdapter = ViewPagerMessangerAdapter(this)
        viewPager.adapter = vpAdapter
        TabLayoutMediator(tab,viewPager){ tabs, position ->

            if(position == 0){
                tabs.text = "Calls"
            }
            if(position == 1){
                tabs.text = "Messages"
            }
            if(position == 2){
                tabs.text = "Chats"
            }

        }.attach()

    }
}