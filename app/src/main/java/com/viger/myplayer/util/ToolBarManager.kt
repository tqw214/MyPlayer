package com.viger.myplayer.util

import android.support.v7.widget.Toolbar
import com.viger.myplayer.R

interface ToolBarManager {

    val toolbar:Toolbar

    fun initMainToolBar() {
        toolbar.setTitle("我的影音")
        toolbar.inflateMenu(R.menu.main)
    }

}