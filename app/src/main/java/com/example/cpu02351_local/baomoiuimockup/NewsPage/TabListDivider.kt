package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.ItemAdapter


class TabListDivider(context: Context) : RecyclerView.ItemDecoration() {

    private val thinDivider = ContextCompat.getDrawable(context, R.drawable.thin_divider)
    private val thickDivider = ContextCompat.getDrawable(context, R.drawable.thick_divider)

    private val drawThinIfBefore = arrayOf(
            ItemAdapter.VIEW_HOLDER_AD_ITEM,
            ItemAdapter.VIEW_HOLDER_MULTI_IMAGE,
            ItemAdapter.VIEW_HOLDER_SINGLE_IMAGE,
            ItemAdapter.VIEW_HOLDER_READ_MORE,
            ItemAdapter.VIEW_HOLDER_VIDEO
    )

    private val drawThickIfIs = arrayOf(
            ItemAdapter.VIEW_HOLDER_NOT_SATISFY,
            ItemAdapter.VIEW_HOLDER_READ_MORE
    )

    private val drawThickIfBefore = arrayOf(
            ItemAdapter.VIEW_HOLDER_HEADER
    )

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        // super.getItemOffsets(outRect, view, parent, state)
        /*
        val index = parent?.getChildAdapterPosition(view)
        if (index!! >= (parent.childCount - 1)) return
        if (shouldDrawThickDivider(parent, index)) {
            outRect?.top = thickDivider?.intrinsicHeight
        } else if (shouldDrawThinDivider(parent, index)) {
            outRect?.top = thinDivider?.intrinsicHeight
        }
        */

        val params = view?.layoutParams as RecyclerView.LayoutParams
        val position = params.viewAdapterPosition
        if (position >= (state!!.itemCount - 1)) return

        if (shouldDrawThickDivider(parent!!, position)) {
            outRect?.set(0, 0, 0, thickDivider?.intrinsicHeight!!)
        } else if (shouldDrawThinDivider(parent, position)) {
            outRect?.set(0, 0, 0, thinDivider?.intrinsicHeight!!)
        }

    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            if (shouldDrawThickDivider(parent, i)) {
                drawDivider(c, parent, child, thickDivider!!)
            } else if (shouldDrawThinDivider(parent, i)) {
                drawDivider(c, parent, child, thinDivider!!)
            }
        }
    }

    private fun drawDivider(c: Canvas, parent: RecyclerView, child: View, divider: Drawable) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val params = child.layoutParams as RecyclerView.LayoutParams
        val top = child.bottom + params.bottomMargin
        val bottom = top + divider.intrinsicHeight
        divider.setBounds(left, top, right, bottom)
        divider.draw(c)
    }

    private fun shouldDrawThinDivider(parent: RecyclerView, index: Int): Boolean {
        val adapter = parent.adapter
        // val viewTypeCur = adapter.getItemViewType(index)
        val viewTypeNext = adapter.getItemViewType(index + 1)
        return (viewTypeNext in drawThinIfBefore)
    }

    private fun shouldDrawThickDivider(parent: RecyclerView, index: Int): Boolean {
        val adapter = parent.adapter
        val viewTypeCur = adapter.getItemViewType(index)
        val viewTypeNext = adapter.getItemViewType(index + 1)
        return (viewTypeCur in drawThickIfIs ||
                viewTypeNext in drawThickIfBefore)
    }

}