package com.example.cpu02351_local.baomoiuimockup.Utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.*


class ItemAdapter(private var items: ArrayList<Item>) : RecyclerView.Adapter<ItemViewHolder>() {

    companion object {
        const val VIEW_HOLDER_HEADER = 1
        const val VIEW_HOLDER_SINGLE_IMAGE = 2
        const val VIEW_HOLDER_MULTI_IMAGE = 3
        const val VIEW_HOLDER_READ_MORE = 4
        const val VIEW_HOLDER_NOT_SATISFY = 5
        const val VIEW_HOLDER_AD_ITEM = 6
        const val VIEW_HOLDER_RECT_VIDEO = 7
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
            VIEW_HOLDER_MULTI_IMAGE -> MultiImageItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_multi_image, parent, false)
            )
            VIEW_HOLDER_READ_MORE -> ReadMoreItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_read_more, parent, false)
            )
            VIEW_HOLDER_NOT_SATISFY -> NotSatisfyItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_not_satisfy, parent, false)
            )
            VIEW_HOLDER_AD_ITEM -> AdItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
            )
            VIEW_HOLDER_RECT_VIDEO -> RectangleVideoItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_rect_video, parent, false)
            )

            else -> throw IllegalStateException("Invalid ViewType in ItemAdapter")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindView(items[position])
    }
}