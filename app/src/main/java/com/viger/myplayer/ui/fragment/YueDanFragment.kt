package com.viger.myplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
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

    val adapter by lazy { YueDanAdapter() }
    val presenter by lazy { YueDanPresenterImpl(this)}

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
    }

    override fun initData() {


    }

}