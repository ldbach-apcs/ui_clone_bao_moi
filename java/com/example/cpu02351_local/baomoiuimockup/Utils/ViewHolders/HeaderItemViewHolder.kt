package com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders

import android.view.View
import android.widget.TextView
import com.example.cpu02351_local.baomoiuimockup.NewsPage.HeaderNewsItem
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.Item

class HeaderItemViewHolder(v : View) : ItemViewHolder(v) {
    private val tv: TextView = v.findViewById(R.id.item_header)
    override fun bindView(item: Item) {
        tv.text = (item as HeaderNewsItem).title.toUpperCase()
    }
}