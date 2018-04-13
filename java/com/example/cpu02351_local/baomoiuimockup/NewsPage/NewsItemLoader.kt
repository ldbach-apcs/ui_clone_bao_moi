package com.example.cpu02351_local.baomoiuimockup.NewsPage

import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader

class NewsItemLoader : ItemLoader() {
    override fun load(): ArrayList<Item> {
        val res = ArrayList<Item>()
        res.add(NewsItem("Title 1"))
        res.add(NewsItem("Title 2"))
        res.add(NewsItem("Title 3"))
        return res
    }

}