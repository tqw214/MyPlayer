package com.viger.myplayer.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.viger.myplayer.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * BaseListFragment
 */

abstract class BaseListFragment<T,D,V:View> : BaseFragment(), BaseView<T> {

    val presenter by lazy {
        getSpecialPresenter()
    }

    abstract fun getSpecialPresenter():BaseListPresenter

    val adapter by lazy {
        getSpecialAdapter()
    }

    abstract fun getSpecialAdapter():BaseListAdapter<D,V>

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        super.initListener()
        recycleView.layoutManager = LinearLayoutManager(this.context)
        //val adapter = HomeAdapter()
        recycleView.adapter = adapter
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    var layoutManager = recyclerView.layoutManager
                    if(layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastVisibleItemPosition = manager.findLastVisibleItemPosition()
                        if(lastVisibleItemPosition == adapter.itemCount - 1) {
                            //最后一条
                            presenter.loadMore(adapter.itemCount-1)
                        }
                    }
                }
            }
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            }
        })
    }

    override fun initData() {
        super.initData()
        presenter.loadDatas()
    }

    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun loadMore(list: T) {
        refreshLayout.isRefreshing = false
        //adapter.loadMore(getList(list))
    }

    override fun loadSuccess(list: T) {
        refreshLayout.isRefreshing = false
        //adapter.updateList(getList(list))
    }

    abstract fun getList(response:T):List<T>

}