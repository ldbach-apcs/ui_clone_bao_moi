package com.example.cpu02351_local.baomoiuimockup.NewsPage

import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader

class NewsItemLoader : ItemLoader() {
    override fun load(title: String): ArrayList<Item> {
        val res = ArrayList<Item>()
        res.add(HeaderNewsItem("Title 1"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 2"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 3"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 4"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 5"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 6"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 7"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 8"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 9"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 10"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 11"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 12"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        return res
    }
}