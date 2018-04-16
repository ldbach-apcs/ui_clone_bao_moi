package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader

class NewsViewPagerAdapter(fm : FragmentManager, private var tabsTitle: Array<String>, var loader: ItemLoader)
    : FragmentStatePagerAdapter(fm) {

    private val frags = ArrayList<Fragment>()

    init {
        for (i in 0 until tabsTitle.size) {
            frags.add(NewsListTabFragment.instance(loader, tabsTitle[i]))
        }
    }

    override fun getItem(position: Int): Fragment = frags[position]

    override fun getCount(): Int = tabsTitle.size
}