package com.example.cpu02351_local.baomoiuimockup.Utils

abstract class Item {
    abstract fun getViewHolderType(): Int
    override fun equals(other: Any?): Boolean = other!!::class == this::class
}