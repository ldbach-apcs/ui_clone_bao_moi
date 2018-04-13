package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.PageFragment

class NewsPageFragment : PageFragment() {
    private lateinit var newsTabsTitle : Array<String>

    companion object {
        @JvmStatic
        fun instance() : NewsPageFragment {
            return NewsPageFragment()
        }
    }

    // Create and caches ViewPagerAdapter
    // Create array of Strings too
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsTabsTitle = context!!.resources!!.getStringArray(R.array.tabs_title_news)

    }

    // Set adapter, bind listeners
    // Create array of Tabs TabLayout.newTab().setText()
    // Inflate views
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    // Remove adapter, but do not destroy the adapter
    // Remove View/ViewGroup references
    override fun onDestroyView() {
        super.onDestroyView()
    }

    // Clear adapter references
    override fun onDestroy() {
        super.onDestroy()
    }
}