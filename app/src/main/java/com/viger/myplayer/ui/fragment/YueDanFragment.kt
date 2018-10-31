package com.viger.myplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.viger.myplayer.R
import com.viger.myplayer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * 悦单界面
 */
class YueDanFragment : BaseFragment() {

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)

    }

}