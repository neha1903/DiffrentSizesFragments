package com.lit.diffrentsizefragments.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentSliderAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    companion object {
        const val TAG = "FragmentStateAdapter"
    }

    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTitleList = mutableListOf<String>()

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        Log.d(TAG, "createFragment: $position  method Called")
        return getItem(position)
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    fun getItem(i: Int): Fragment { // i is position in here
        return fragmentList[i]
    }

    // gets the Fragment Name
    fun getItemTitle(i: Int): String {
        return fragmentTitleList[i]
    }

}