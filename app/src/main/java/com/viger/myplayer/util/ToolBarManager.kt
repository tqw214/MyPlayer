package com.viger.myplayer.util

import android.widget.Toolbar

interface ToolBarManager {

    val toolbar:Toolbar

    fun initMainToolBar() {
        toolbar.setTitle("我的影音")
    }

}