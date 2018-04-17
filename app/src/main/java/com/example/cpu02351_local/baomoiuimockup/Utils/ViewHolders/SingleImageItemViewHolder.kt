package com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.view.View
import android.view.WindowManager
import com.example.cpu02351_local.baomoiuimockup.Utils.Item
import kotlinx.android.synthetic.main.item_single_image.view.*


class SingleImageItemViewHolder(v: View, context: Context) : ItemViewHolder(v) {

    companion object {
        const val PADDING = 8
    }

    init {
        val metrics = Resources.getSystem().displayMetrics
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        val paddingInPx = (PADDING * metrics.density + 0.5).toInt()
        v.item_img.layoutParams.width = (size.x - 4 * paddingInPx) / 3
        v.requestLayout()
    }

    // Title, image, source, timeElapse, Comments, comment icon
    override fun bindView(item: Item) {
        // Do nothing for now
    }
}