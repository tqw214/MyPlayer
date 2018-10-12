package com.viger.myplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.roughike.bottombar.BottomBar
import com.viger.myplayer.R
import com.viger.myplayer.base.BaseActivity
import com.viger.myplayer.util.ToolBarManager
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), ToolBarManager {

    override val toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        find<BottomBar>(R.id.bottomBar).setOnTabSelectListener {
            if(it == R.id.tab_home) {
                toast("首页")
            }
            if(it == R.id.tab_mv) {
                toast("mv")
            }
        }
    }

}
