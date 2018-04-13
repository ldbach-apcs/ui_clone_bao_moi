package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader

class NewsViewPagerAdapter(fm : FragmentManager, var tabsTitle: Array<String>, var loader: ItemLoader)
    : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment = NewsListTabFragment.instance(loader, tabsTitle[position])

    override fun getCount(): Int = tabsTitle.size
}