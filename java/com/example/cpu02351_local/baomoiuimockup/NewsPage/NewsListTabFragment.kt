package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader
import com.example.cpu02351_local.baomoiuimockup.Utils.ListTabFragment

class NewsListTabFragment : ListTabFragment() {

    private lateinit var items : ArrayList<Item>
    private lateinit var loader: ItemLoader

    companion object {
        @JvmStatic
        fun instance(loader: ItemLoader): NewsListTabFragment {
            val newInstance = NewsListTabFragment()
            newInstance.loader = loader
            return newInstance
        }
    }

    override fun isDataCreated(savedInstanceState: Bundle?): Boolean {
        return false
    }

    override fun loadServerData() : ArrayList<Item> {
        return loader.load()
    }

    override fun loadSavedData(): ArrayList<Item> {
        return ArrayList()
    }

    // Create array of NewsItem to hold data, recyclerView Adapter too

    // Check if Data is cached, if not load them
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isDataCreated(savedInstanceState)) {
            items = loadSavedData()
        } else {
            loadServerData()
        }
    }

    // Save loaded data
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    // Inflate layout, reference recyclerView, create adapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    // de-reference all things
    override fun onDestroyView() {
        super.onDestroyView()
    }
}