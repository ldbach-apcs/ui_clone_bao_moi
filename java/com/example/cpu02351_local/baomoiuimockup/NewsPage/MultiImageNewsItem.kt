package com.example.cpu02351_local.baomoiuimockup.NewsPage

import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemAdapter

class MultiImageNewsItem : Item() {
    override fun getViewHolderType(): Int = ItemAdapter.VIEW_HOLDER_MULTI_IMAGE
}