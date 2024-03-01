package com.example.cinemax_play

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.cinemax_play.fragments.PopularMovies
import com.example.cinemax_play.fragments.TopMovies
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewPager : ViewPager = findViewById(R.id.viewPage)
        var tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val fragmentAdapter = MyViewPagerAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(PopularMovies(),"Popular Movies")
        fragmentAdapter.addFragment(TopMovies(),"Top Movies")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)




    }
}