package com.example.cpu02351_local.baomoiuimockup.Utils.CustomViewGroups

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.CustomViews.ScaledImage

class SingleImageLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        FrameLayout(context, attrs, defStyleAttr) {
    private val paddingInPx: Int = resources.getDimension(R.dimen.padding).toInt()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val totalWidth = MeasureSpec.getSize(widthMeasureSpec)
        val imageView = findViewById<ScaledImage>(R.id.item_img_thumbnail)
        val imgW = (measuredWidth - paddingInPx) / 3
        val imgH = (imgW * imageView.scaleRatio).toInt()
        if (imageView.visibility != View.GONE) {
            imageView.measure(
                    View.MeasureSpec.makeMeasureSpec(imgW, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(imgH, View.MeasureSpec.EXACTLY))
        }

        val titleView = findViewById<View>(R.id.item_title)
        if (titleView.visibility != View.GONE) {
            titleView.measure(View.MeasureSpec.makeMeasureSpec(totalWidth - imgW, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        }

        val srcView = findViewById<View>(R.id.item_source)
        if (srcView.visibility != View.GONE) {
            srcView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        }

        val elapseView = findViewById<View>(R.id.item_time)
        if (elapseView.visibility != View.GONE) {
            elapseView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        }

        setMeasuredDimension(totalWidth,
                Math.max(imgH, titleView.measuredHeight + srcView.measuredHeight) + paddingTop + paddingBottom)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        //super.onLayout(changed, left, top, right, bottom)
        val imageView = findViewById<ScaledImage>(R.id.item_img_thumbnail)
        val imageViewMarginEnd = (imageView.layoutParams as LayoutParams).marginEnd
        if (imageView.visibility != View.INVISIBLE) {
            imageView.layout(0, 0, imageView.measuredWidth, imageView.measuredHeight)
        }

        val titleView = findViewById<View>(R.id.item_title)
        if (titleView.visibility != View.INVISIBLE) {
            val titleViewMarginStart = (titleView.layoutParams as LayoutParams).marginStart
            titleView.layout(
                    imageView.measuredWidth + imageViewMarginEnd + titleViewMarginStart,
                    paddingTop,
                    imageView.measuredWidth + imageViewMarginEnd + titleViewMarginStart + titleView.measuredWidth,
                    paddingTop + titleView.measuredHeight)
        }

        val sourceView = findViewById<View>(R.id.item_source)
        if (sourceView.visibility != View.INVISIBLE) {
            val titleViewMarginBot = (titleView.layoutParams as LayoutParams).bottomMargin
            val topSourceView = Math.max(titleView.measuredHeight + titleViewMarginBot, imageView.bottom - sourceView.measuredHeight)
            sourceView.layout(
                    titleView.left,
                    topSourceView,
                    titleView.left + sourceView.measuredWidth,
                    topSourceView + sourceView.measuredHeight)
        }

        val elapseView = findViewById<View>(R.id.item_time)
        if (elapseView.visibility != View.INVISIBLE) {
            val sourceViewMarginEnd = (sourceView.layoutParams as LayoutParams).marginEnd
            val elapseViewMarginStart = (elapseView.layoutParams as LayoutParams).marginStart
            val startElapseView = sourceView.left + sourceView.measuredWidth + sourceViewMarginEnd + elapseViewMarginStart
            elapseView.layout(
                    startElapseView,
                    sourceView.top,
                    startElapseView + elapseView.measuredWidth,
                    sourceView.top + elapseView.measuredHeight
            )
        }
    }
}