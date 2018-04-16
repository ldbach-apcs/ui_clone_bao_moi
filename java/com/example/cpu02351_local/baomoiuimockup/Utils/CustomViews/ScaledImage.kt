package com.example.cpu02351_local.baomoiuimockup.Utils.CustomViews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.content.res.TypedArray
import com.example.cpu02351_local.baomoiuimockup.R


class ScaledImage @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private var scaledRatio: Float = 0.75f

    init {
        if (attrs != null) {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.ScaledImage, 0, 0)
            try {
                scaledRatio = ta.getFloat(R.styleable.ScaledImage_scaledRatio, 0.75f)
            } finally {
                ta.recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val w = measuredWidth
        setMeasuredDimension(w, (w * scaledRatio).toInt())
    }
}