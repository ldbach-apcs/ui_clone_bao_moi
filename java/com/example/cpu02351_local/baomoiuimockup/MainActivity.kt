package com.example.cpu02351_local.baomoiuimockup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsPageFragment
import com.example.cpu02351_local.baomoiuimockup.Utils.PageFragment

class MainActivity : AppCompatActivity() {

    private val navFragments = ArrayList<PageFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPages()
        setupUiInteraction()
    }

    // Creation of page objects will also create Tabs inside
    // This is a heavy work and should be pushed to background Thread
    private fun setupPages() {
        navFragments.add(NewsPageFragment.instance())
    }

    // BottomNavigationClick is initialized in here
    private fun setupUiInteraction() {

    }

    // Clear all strong references
    override fun onDestroy() {
        super.onDestroy()
    }
}
