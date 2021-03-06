package com.example.cpu02351_local.baomoiuimockup.Utils

abstract class ItemLoader {
    abstract fun load(title: String): ArrayList<Item>
    abstract fun loadMore(title: String): ArrayList<Item>
}