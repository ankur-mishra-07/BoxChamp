package com.example.boxchamp

import android.os.Build
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.boxchamp.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        viewPager.addOnPageChangeListener(this)
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tabs.setSelectedTabIndicatorColor(getColor(android.R.color.white))
        }
        tabs.addOnTabSelectedListener(this)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        tab?.position?.let { makeFabChanges(it) }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.position?.let { makeFabChanges(it) }
    }

    private fun makeFabChanges(position: Int) {
        when (position) {
            0 -> {
                fab.visibility = View.VISIBLE
            }
            1 -> {
                fab.visibility = View.GONE
            }
            2 -> {
                fab.visibility = View.GONE
            }
            3 -> {
                fab.visibility = View.GONE
            }
        }

    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        makeFabChanges(position)
    }

    override fun onPageSelected(position: Int) {
        makeFabChanges(position)
    }
}