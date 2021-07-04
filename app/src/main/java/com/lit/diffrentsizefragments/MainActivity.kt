package com.lit.diffrentsizefragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.lit.diffrentsizefragments.adapter.FragmentSliderAdapter
import com.lit.diffrentsizefragments.databinding.ActivityMainBinding
import com.lit.diffrentsizefragments.fragments.Fragment1
import com.lit.diffrentsizefragments.fragments.Fragment2
import com.lit.diffrentsizefragments.fragments.Fragment3

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val sliderAdapter = FragmentSliderAdapter(this@MainActivity)
        sliderAdapter.addFragment(Fragment1(), "Fragment 1")
        sliderAdapter.addFragment(Fragment2(), "Fragment 2")
        sliderAdapter.addFragment(Fragment3(), "Fragment 3")
        // add Fragment


        binding.viewPager.apply {
            adapter = sliderAdapter
            currentItem = 0
            setPageTransformer(NoPageTransformer())
        }

        TabLayoutMediator(binding.tabsLayout, binding.viewPager) { tab, position ->
            tab.text = sliderAdapter.getItemTitle(position)
        }.attach()


    }

    private class NoPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(
            view: View,
            position: Float
        ) {
            view.translationX = view.width * -position
            if (position <= -1.0f || position >= 1.0f) {
                view.visibility = View.GONE
            } else if (position == 0.0f) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        }
    }
}