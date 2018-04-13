package com.example.cpu02351_local.baomoiuimockup

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsPageFragment
import com.example.cpu02351_local.baomoiuimockup.Utils.PageFragment

class MainActivity : AppCompatActivity() {

    private val navFragments = ArrayList<PageFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPages()
        setupUiInteraction()
        replaceFragment(navFragments[0], null)
    }

    // Creation of page objects will also create Tabs inside
    // This is a heavy work and should be pushed to background Thread
    private fun setupPages() {
        navFragments.add(NewsPageFragment.instance())
        navFragments.add(NewsPageFragment.instance())
    }

    // BottomNavigationClick is initialized in here
    private fun setupUiInteraction() {
        val nav = findViewById<BottomNavigationView>(R.id.navigation)
        nav.setOnNavigationItemSelectedListener {
            it -> when (it.itemId) {
            R.id.navigation_news -> {
                replaceFragment(navFragments[0], null)
                true
            }
            R.id.navigation_video -> {
                replaceFragment(navFragments[1], null)
                true
            }
            else -> false
        }}
    }

    private fun replaceFragment(fragment: PageFragment, tag: String?) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, tag)
                .commit()

    }

    // Clear all strong references
    override fun onDestroy() {
        super.onDestroy()
    }
}
