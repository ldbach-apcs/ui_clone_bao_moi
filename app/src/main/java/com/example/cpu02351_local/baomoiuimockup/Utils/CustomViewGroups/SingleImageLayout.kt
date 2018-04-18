package com.example.cpu02351_local.baomoiuimockup.Utils.CustomViewGroups

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import com.example.cpu02351_local.baomoiuimockup.Utils.CustomViews.ScaledImage
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.SingleImageItemViewHolder

class SingleImageLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        FrameLayout(context, attrs, defStyleAttr) {

    val size = Point()
    private val paddingInPx: Int

    init {
        val metrics = Resources.getSystem().displayMetrics
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        display.getSize(size)
        paddingInPx = (SingleImageItemViewHolder.PADDING * metrics.density + 0.5).toInt()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val totalWidth = MeasureSpec.getSize(widthMeasureSpec)
        val imageView = getChildAt(0) as ScaledImage
        val imgW = (measuredWidth - paddingInPx) / 3
        val imgH = (imgW * imageView.scaleRatio).toInt()
        imageView.measure(
                View.MeasureSpec.makeMeasureSpec(imgW, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(imgH, View.MeasureSpec.EXACTLY))

        // Fill what's left in horizontal
        // Take whatever space needed in vertical
        val titleView = getChildAt(1)
        titleView.measure(View.MeasureSpec.makeMeasureSpec(totalWidth - imgW, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

        val srcView = getChildAt(2)
        srcView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

        val elapseView = getChildAt(3)
        elapseView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

        setMeasuredDimension(totalWidth,
                Math.max(imgH, titleView.measuredHeight + srcView.measuredHeight) + paddingTop + paddingBottom)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        //super.onLayout(changed, left, top, right, bottom)

        val imageView = getChildAt(0)
        val imageViewMarginEnd = (imageView.layoutParams as LayoutParams).marginEnd
        imageView.layout(0, 0, imageView.measuredWidth, imageView.measuredHeight)

        val titleView = getChildAt(1)
        val titleViewMarginStart = (titleView.layoutParams as LayoutParams).marginStart
        titleView.layout(
                imageView.measuredWidth + imageViewMarginEnd + titleViewMarginStart,
                paddingTop,
                imageView.measuredWidth + imageViewMarginEnd + titleViewMarginStart + titleView.measuredWidth,
                paddingTop + titleView.measuredHeight)

        val sourceView = getChildAt(2)
        val titleViewMarginBot = (titleView.layoutParams as LayoutParams).bottomMargin
        val topSourceView = Math.max(titleView.measuredHeight + titleViewMarginBot, imageView.bottom - sourceView.measuredHeight)
        sourceView.layout(
                titleView.left,
                topSourceView,
                titleView.left + sourceView.measuredWidth,
                topSourceView + sourceView.measuredHeight)

        val elapseView = getChildAt(3)
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