package com.example.cpu02351_local.baomoiuimockup.NewsPage

import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsItems.*
import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.RectangleVideoItemViewHolder

class NewsItemLoader : ItemLoader() {
    override fun load(title: String): ArrayList<Item> {
        val res = ArrayList<Item>()
        res.add(MultiImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(AdNewsItem())
        res.add(ReadMoreNewsItem())
        res.add(VideoNewsItem())
        res.add(HeaderNewsItem("Title 1"))
        res.add(MultiImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 2"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(ReadMoreNewsItem())
        res.add(HeaderNewsItem("Title 3"))
        res.add(SingleImageNewsItem())
        res.add(MultiImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(NotSatisfyNewsItem())
        res.add(HeaderNewsItem("Title 4"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 5"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(VideoNewsItem())
        res.add(HeaderNewsItem("Title 6"))
        res.add(SingleImageNewsItem())
        res.add(MultiImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(ReadMoreNewsItem())
        res.add(HeaderNewsItem("Title 7"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 8"))
        res.add(SingleImageNewsItem())
        res.add(MultiImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(AdNewsItem())
        res.add(HeaderNewsItem("Title 9"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 10"))
        res.add(SingleImageNewsItem())
        res.add(HeaderNewsItem("Title 11"))
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(ReadMoreNewsItem())
        res.add(NotSatisfyNewsItem())
        res.add(HeaderNewsItem("Title 12"))
        res.add(MultiImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(SingleImageNewsItem())
        res.add(ReadMoreNewsItem())
        return res
    }
}