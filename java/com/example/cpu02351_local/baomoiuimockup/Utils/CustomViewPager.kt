package com.example.cpu02351_local.baomoiuimockup.Utils

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.view.ViewPager

class CustomViewPager(context : Context) : ViewPager(context) {
    override fun onSaveInstanceState(): Parcelable {
        super.onSaveInstanceState()
        val save = Bundle()
        save.putInt("cur_pos", this.currentItem)
        return save
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        this.currentItem = (state as Bundle).getInt("cur_pos")
        super.onRestoreInstanceState(state)
    }
}