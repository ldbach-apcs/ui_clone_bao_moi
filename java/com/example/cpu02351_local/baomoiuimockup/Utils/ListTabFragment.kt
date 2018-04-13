package com.example.cpu02351_local.baomoiuimockup.Utils

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsItem

abstract class ListTabFragment : Fragment() {
    abstract fun loadServerData(): ArrayList<Item>
    abstract fun isDataCreated(savedInstanceState: Bundle?): Boolean
    abstract fun loadSavedData(): ArrayList<Item>


}