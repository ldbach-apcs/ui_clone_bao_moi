package com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.view.View
import android.view.WindowManager
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import kotlinx.android.synthetic.main.item_single_image.view.*


class SingleImageItemViewHolder(v: View, context: Context) : ItemViewHolder(v) {

    private val paddingInPx: Int = context.resources.getDimension(R.dimen.padding).toInt()


    init {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        v.item_img_thumbnail.layoutParams.width = (size.x - 4 * paddingInPx) / 3
        v.requestLayout()
    }

    // Title, image, source, timeElapse, Comments, comment icon
    override fun bindView(item: Item) {
        // Do nothing for now

    }
}