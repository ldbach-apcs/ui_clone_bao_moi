package com.example.cpu02351_local.baomoiuimockup.Utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.HeaderItemViewHolder
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.ItemViewHolder
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.SingleImageItemViewHolder


class ItemAdapter(private var items: ArrayList<Item>) : RecyclerView.Adapter<ItemViewHolder>() {

    companion object {
        const val VIEW_HOLDER_HEADER = 1
        const val VIEW_HOLDER_SINGLE_IMAGE = 2
    }


    override fun getItemViewType(position: Int): Int = items[position].getViewHolderType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when(viewType) {
            VIEW_HOLDER_HEADER -> HeaderItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            )
            VIEW_HOLDER_SINGLE_IMAGE -> SingleImageItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_single_image, parent, false)
            )
            else -> TODO("Throw an exception here")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindView(items[position])
    }
}