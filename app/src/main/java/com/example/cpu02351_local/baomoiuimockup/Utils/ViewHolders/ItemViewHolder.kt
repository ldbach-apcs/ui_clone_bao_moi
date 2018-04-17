package com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cpu02351_local.baomoiuimockup.Utils.Item

abstract class ItemViewHolder(v : View) : RecyclerView.ViewHolder(v) {
    abstract fun bindView(item : Item)
}