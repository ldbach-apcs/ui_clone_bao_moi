package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.support.v7.util.DiffUtil
import com.example.cpu02351_local.baomoiuimockup.Utils.Item

class NewsItemDiffUtilCallback(private var oldItems: List<Item>,
                               private var newItems: List<Item>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Should have some id here?
        return Utils.isSameItem(oldItems[oldItemPosition], newItems[newItemPosition])
    }

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Let's assume that the same news with unique ID always have the same content
        return true
    }

    // Override equals in each subclass, for now return true
    class Utils {
        companion object {
            @JvmStatic
            fun isSameItem(old: Item, new: Item): Boolean {
                return old == new
            }
        }
    }
}