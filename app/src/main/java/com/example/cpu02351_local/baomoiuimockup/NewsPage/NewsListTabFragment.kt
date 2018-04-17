package com.example.cpu02351_local.baomoiuimockup.NewsPage

import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cpu02351_local.baomoiuimockup.NewsPage.NewsItems.*
import com.example.cpu02351_local.baomoiuimockup.R
import com.example.cpu02351_local.baomoiuimockup.Utils.*


class NewsListTabFragment : ListTabFragment(), SwipeRefreshLayout.OnRefreshListener, OnRecyclerViewBottomReachedListener {
    override fun onBottomReached() {
        items.add(LoadingNewsItem())
        adapter?.notifyItemInserted(items.size - 1)

        Handler().postDelayed({
            items.removeAt(items.size - 1)
            adapter?.notifyItemRemoved(items.size)
            //Generating more data
            items.add(HeaderNewsItem("After reach bottom at ${items.size - 1}"))
            items.add(MultiImageNewsItem())
            items.add(SingleImageNewsItem())
            items.add(AdNewsItem())
            items.add(MultiImageNewsItem())
            adapter?.notifyDataSetChanged()
            adapter?.setLoaded()
        }, 3000)
    }

    override fun onRefresh() {
        swipeContainer.post {
            populateRecyclerView(null)
        }
    }

    private lateinit var items : ArrayList<Item>
    private lateinit var loader: ItemLoader
    private lateinit var title: String
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeContainer: SwipeRefreshLayout
    private var adapter : ItemAdapter? = null

    companion object {
        @JvmStatic
        fun instance(loader: ItemLoader, title: String): NewsListTabFragment {
            val newInstance = NewsListTabFragment()
            newInstance.loader = loader
            newInstance.title = title
            return newInstance
        }
    }

    override fun isDataCreated(savedInstanceState: Bundle?): Boolean {
        return false
    }

    override fun loadServerData() : ArrayList<Item> {
        return loader.load(title)
    }

    override fun loadSavedData(): ArrayList<Item> {
        return ArrayList()
    }

    private fun loadData(savedInstanceState: Bundle?) {
        items = if (isDataCreated(savedInstanceState)) {
            loadSavedData()
        } else {
            loadServerData()
        }
    }

    // Inflate layout, reference recyclerView, create adapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.fragment_news_tab, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        swipeContainer = rootView.findViewById(R.id.swipe_container)

        recyclerView.addItemDecoration(TabListDivider(context!!))
        swipeContainer.setOnRefreshListener(this)
        swipeContainer.post {
            populateRecyclerView(savedInstanceState)
        }
        return rootView
    }

    private fun populateRecyclerView(savedInstanceState: Bundle?) {
        swipeContainer.isRefreshing = true
        loadData(savedInstanceState)
        swipeContainer.isRefreshing = false
        adapter = ItemAdapter(items, context!!, recyclerView)
        adapter!!.setOnRecyclerViewBottomReached(this)
        recyclerView.adapter = null
        recyclerView.adapter = adapter
    }

    // de-reference all things
    override fun onDestroyView() {
        recyclerView.layoutManager = null
        recyclerView.adapter = null
        super.onDestroyView()
    }
}