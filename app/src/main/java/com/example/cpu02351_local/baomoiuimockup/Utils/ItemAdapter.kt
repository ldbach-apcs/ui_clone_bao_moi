package com.example.cpu02351_local.baomoiuimockup.Utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.annotation.MainThread
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.ViewHolders.*
import android.support.v7.widget.LinearLayoutManager
import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsItemDiffUtilCallback
import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsListTabFragment
import java.util.*


class ItemAdapter(private var items: ArrayList<Item>, private var context: Context, private var recyclerView: RecyclerView) : RecyclerView.Adapter<ItemViewHolder>() {

    private var listener : OnRecyclerViewBottomReachedListener? = null
    private var isLoading = false

    init {
        // notifyDataSetChanged()
        val layoutManger = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (listener == null) return
                val visibleItemCount = layoutManger.childCount
                val totalItemCount = layoutManger.itemCount
                val pastVisibleItems = layoutManger.findFirstVisibleItemPosition()

                // End of list
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    // If it is loading already, don't need to waste resource in synchronizing this var
                    if (isLoading) return
                    synchronized(isLoading) {
                        if (isLoading) return
                        else isLoading = true
                    }
                    listener!!.onBottomReached()
                }
            }
        })
    }


    companion object {
        const val VIEW_HOLDER_LOADING = 0
        const val VIEW_HOLDER_HEADER = 1
        const val VIEW_HOLDER_SINGLE_IMAGE = 2
        const val VIEW_HOLDER_MULTI_IMAGE = 3
        const val VIEW_HOLDER_READ_MORE = 4
        const val VIEW_HOLDER_NOT_SATISFY = 5
        const val VIEW_HOLDER_AD_ITEM = 6
        const val VIEW_HOLDER_VIDEO = 7
    }

    override fun getItemViewType(position: Int): Int = items[position].getViewHolderType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when(viewType) {
            VIEW_HOLDER_LOADING -> LoadingItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
            )
            VIEW_HOLDER_HEADER -> HeaderItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            )
            VIEW_HOLDER_SINGLE_IMAGE -> SingleImageItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_single_image, parent, false),
                    context
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
                    LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false),
                    context
            )
            VIEW_HOLDER_VIDEO -> VideoItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
            )

            else -> throw IllegalStateException("Invalid ViewType in ItemAdapter")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    fun setOnRecyclerViewBottomReached(listener: OnRecyclerViewBottomReachedListener) {
        this.listener = listener
    }

    fun setLoaded() {
        isLoading = false
    }

    private val mPendingUpdates = ArrayDeque<List<Item>>()
    private val mHandler = Handler(Looper.getMainLooper())

    @MainThread
    private fun hasPendingUpdates() : Boolean {
        return !mPendingUpdates.isEmpty()
    }
    @MainThread
    private fun peekLast(): List<Item> {
        return if (mPendingUpdates.isEmpty())
            items
        else
            mPendingUpdates.peekLast()
    }
    @MainThread
    fun updateItemsAsync(items: List<Item>, newsListTabFragment: NewsListTabFragment) {
        mPendingUpdates.add(items)
        if (hasPendingUpdates())
            internalUpdate(items, newsListTabFragment)
    }

    private fun internalUpdate(newList: List<Item>, newsListTabFragment: NewsListTabFragment) {
        Thread(Runnable {
            val result = DiffUtil.calculateDiff(NewsItemDiffUtilCallback(items, newList), true)
            mHandler.postDelayed({
                items = newList as ArrayList<Item>
                result.dispatchUpdatesTo(this@ItemAdapter)
                processQueue(newsListTabFragment)

            }, 2000)
        }).start()
    }

    @MainThread
    private fun processQueue(newsListTabFragment: NewsListTabFragment) {
        mPendingUpdates.remove()
        if (hasPendingUpdates()) {
            if (mPendingUpdates.size > 1) {
                val lastList = peekLast()
                mPendingUpdates.clear()
                mPendingUpdates.add(lastList)
            }
            internalUpdate(mPendingUpdates.peek(), newsListTabFragment)
        }
        recyclerView.stopScroll()
        recyclerView.scrollToPosition(0)
        newsListTabFragment.doneLoading()
    }

    fun updateItems(newItems : List<Item>) {
        val diffCallback = NewsItemDiffUtilCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
        recyclerView.stopScroll()
        recyclerView.scrollToPosition(0)
    }
}