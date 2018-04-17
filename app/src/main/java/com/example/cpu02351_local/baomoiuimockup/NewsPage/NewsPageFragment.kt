package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.CustomViewPager
import com.example.cpu02351_local.baomoiuimockup.Utils.PageFragment
import kotlinx.android.synthetic.main.fragment_news_page.*

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
        newsTabsTitle = getTabTitles(savedInstanceState)
        adapterNews = NewsViewPagerAdapter(childFragmentManager, newsTabsTitle!!, NewsItemLoader())
        val context = this.context!!
        createViewPager(context)
        createTabLayout(context)
        viewPager?.adapter = adapterNews
    }

    private fun getTabTitles(savedInstanceState: Bundle?) =
            (savedInstanceState?.getStringArray("list_tabs")
                    ?: context!!.resources!!.getStringArray(R.array.tabs_title_news))

    private fun createTabLayout(context: Context) {
        tabLayout = TabLayout(context)
        tabLayout!!.id = View.generateViewId()
        tabLayout!!.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        tabLayout!!.tabMode = TabLayout.MODE_SCROLLABLE
        tabLayout!!.overScrollMode = TabLayout.OVER_SCROLL_IF_CONTENT_SCROLLS
        tabLayout!!.setBackgroundColor(ResourcesCompat.getColor(
                context.resources, R.color.colorPrimary, null))


        for (i in 0 until newsTabsTitle?.size!!) {
            tabLayout!!.addTab(tabLayout!!.newTab().setText(newsTabsTitle!![i]))
        }
    }

    private fun createViewPager(context: Context) {
        viewPager = CustomViewPager(context)
        viewPager!!.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        viewPager!!.id = View.generateViewId()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArray("list_tabs", newsTabsTitle)
        super.onSaveInstanceState(outState)
    }

    // Set adapterNews, bind listeners
    // Create array of Tabs TabLayout.newTab().setText()
    // Inflate views
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_news_page, container, false)
        // Use dynamically created objects instead
        tabLayout!!.addOnTabSelectedListener(this)
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        val root = rootView.findViewById<LinearLayout>(R.id.rootView)
        root.addView(tabLayout)
        root.addView(viewPager)
        return rootView
    }

    // Remove adapterNews, but do not destroy the adapterNews
    // Remove View/ViewGroup references
    override fun onDestroyView() {
        rootView.removeView(viewPager)
        rootView.removeView(tabLayout)
        viewPager?.clearOnPageChangeListeners()
        tabLayout?.clearOnTabSelectedListeners()
        super.onDestroyView()
    }

    // Clear adapterNews references
    override fun onDestroy() {
        newsTabsTitle = null
        adapterNews = null
        tabLayout = null
        viewPager = null
        super.onDestroy()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager!!.currentItem = tab!!.position
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onTabUnselected(tab: TabLayout.Tab?) {}
}
