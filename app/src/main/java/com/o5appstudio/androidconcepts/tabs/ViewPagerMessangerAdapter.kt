package com.o5appstudio.androidconcepts.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.o5appstudio.androidconcepts.fragments.AFragment
import com.o5appstudio.androidconcepts.fragments.BFragment
import com.o5appstudio.androidconcepts.fragments.CFragment

//With ViewPager
//class ViewPagerMessangerAdapter(fm: FragmentManager) :
//    FragmentStatePagerAdapter(fm) {
//
//        val fragments = listOf(
//            AFragment(),
//            BFragment(),
//            CFragment(),
//        )
//
//
//    override fun getCount(): Int {
//        return fragments.size //no of tabs
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return  fragments[position]
//    }

//With ViewPager2

class ViewPagerMessangerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    val fragments = listOf(
            AFragment(),
            BFragment(),
            CFragment(),
        )
    override fun getItemCount(): Int {
            return fragments.size //no of tabs
    }

    override fun createFragment(position: Int): Fragment {
            return  fragments[position]
    }


}