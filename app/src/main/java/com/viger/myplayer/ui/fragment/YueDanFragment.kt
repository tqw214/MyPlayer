package com.viger.myplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.itheima.player.model.bean.YueDanBean
import com.viger.myplayer.R
import com.viger.myplayer.adapter.YueDanAdapter
import com.viger.myplayer.base.BaseFragment
import com.viger.myplayer.presenter.impl.YueDanPresenterImpl
import com.viger.myplayer.view.YueDanView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * 悦单界面fragment
 */
class YueDanFragment : BaseFragment(), YueDanView {

    override fun onError(message: String?) {
        refreshLayout.isRefreshing = false
        myToast("加载数据失败")
    }

    override fun loadSuccess(response: YueDanBean) {
        myToast("加载数据成功")
        refreshLayout.isRefreshing = false
        adapter.updateList(response.playLists)
    }

    override fun loadMore(response: YueDanBean) {

    }

    val adapter by lazy { YueDanAdapter() }
    val presenter by lazy { YueDanPresenterImpl(this)}

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
    }

    override fun initData() {
        presenter.loadDatas()

    }

}