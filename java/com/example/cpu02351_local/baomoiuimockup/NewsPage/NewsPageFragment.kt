package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.PageFragment

class NewsPageFragment : PageFragment(), TabLayout.OnTabSelectedListener {
    private var newsTabsTitle : Array<String>? = null
    private var adapterNews : NewsViewPagerAdapter? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    companion object {
        @JvmStatic
        fun instance() : NewsPageFragment {
            return NewsPageFragment()
        }
    }

    // Create and caches NewsViewPagerAdapter
    // Create array of Strings too
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsTabsTitle = savedInstanceState?.getStringArray("list_tabs")
                ?: context!!.resources!!.getStringArray(R.array.tabs_title_news)
        adapterNews = NewsViewPagerAdapter(childFragmentManager, newsTabsTitle!!, NewsItemLoader())
        viewPager?.adapter = adapterNews
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArray("list_tabs", newsTabsTitle)
    }

    // Set adapterNews, bind listeners
    // Create array of Tabs TabLayout.newTab().setText()
    // Inflate views
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_news_page, container, false)
        tabLayout = rootView.findViewById(R.id.tabLayout)
        viewPager = rootView.findViewById(R.id.viewPager)

        // Can i save these tabs too?
        for (i in 0 until newsTabsTitle?.size!!) {
            tabLayout!!.addTab(tabLayout!!.newTab().setText("$newsTabsTitle[i]"))
        }
        tabLayout?.addOnTabSelectedListener(this)
        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        return rootView
    }

    // Remove adapterNews, but do not destroy the adapterNews
    // Remove View/ViewGroup references
    override fun onDestroyView() {
        viewPager?.clearOnPageChangeListeners()
        tabLayout?.clearOnTabSelectedListeners()
        tabLayout = null
        viewPager = null
        super.onDestroyView()
    }

    // Clear adapterNews references
    override fun onDestroy() {
        newsTabsTitle = null
        adapterNews = null
        super.onDestroy()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager?.currentItem = tab?.position!!
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onTabUnselected(tab: TabLayout.Tab?) {}
}
