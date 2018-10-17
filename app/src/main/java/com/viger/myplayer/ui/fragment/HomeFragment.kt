package com.viger.myplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.viger.myplayer.R
import com.viger.myplayer.adapter.HomeAdapter
import com.viger.myplayer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        super.initListener()
        recycleView.layoutManager = LinearLayoutManager(this.context)
        val adapter = HomeAdapter()
        recycleView.adapter = adapter
    }

    override fun initData() {
        super.initData()


    }



}