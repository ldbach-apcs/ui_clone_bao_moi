package com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsItems

import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemAdapter

class ReadMoreNewsItem : Item() {
    override fun getViewHolderType(): Int = ItemAdapter.VIEW_HOLDER_READ_MORE
}