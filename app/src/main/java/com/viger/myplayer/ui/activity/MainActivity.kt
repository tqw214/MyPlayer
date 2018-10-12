package com.viger.myplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.roughike.bottombar.BottomBar
import com.viger.myplayer.R
import com.viger.myplayer.base.BaseActivity
import com.viger.myplayer.util.FragmentUtil
import com.viger.myplayer.util.ToolBarManager
import org.jetbrains.anko.find

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
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it), it.toString())
            transaction.commit()
        }
    }

}
