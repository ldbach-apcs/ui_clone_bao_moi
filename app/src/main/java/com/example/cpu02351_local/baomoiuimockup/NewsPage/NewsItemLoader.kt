package com.example.cpu02351_local.baomoiuimockup.NewsPage

import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsItems.*
import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemLoader
import java.util.*
import kotlin.collections.ArrayList

class NewsItemLoader : ItemLoader() {
    override fun loadMore(title: String): ArrayList<Item> {
        return randomLoading(5)
    }

    override fun load(title: String): ArrayList<Item> = randomLoading()

    private fun randomLoading(size : Int = 30): ArrayList<Item> {

        val res = ArrayList<Item>()
        val random = Random(System.currentTimeMillis())

        for (i in 0 until size) {
            when (rand(1, 7, random)) {
                1 -> res.add(HeaderNewsItem("Header at position $i"))
                2 -> res.add(SingleImageNewsItem())
                3 -> res.add(MultiImageNewsItem())
                4 -> res.add(ReadMoreNewsItem())
                5 -> res.add(NotSatisfyNewsItem())
                6 -> res.add((AdNewsItem()))
                7 -> res.add(VideoNewsItem())
                else -> throw IllegalStateException("Random generator in NewsItemLoader returns invalid type")
            }
        }

        return res
    }

    private fun rand(from: Int, to: Int, random: Random) : Int {
        return random.nextInt(to - from) + from
    }
}