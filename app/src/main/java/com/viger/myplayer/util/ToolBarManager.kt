package com.viger.myplayer.util

import android.content.Intent
import android.support.v7.widget.Toolbar
import com.viger.myplayer.R
import com.viger.myplayer.ui.activity.SettingActivity

interface ToolBarManager {

    val toolbar:Toolbar

    fun initMainToolBar() {
        toolbar.setTitle("我的影音")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener {
            toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
            true
        }
//        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when(item?.itemId) {
//                    R.id.setting->{
//                        //Toast.makeText(toolbar.context, "点击了设置", Toast.LENGTH_SHORT).show()
//                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
//                    }
//                }
//                return true
//            }
//        })
    }

    fun initSettingToolbar() {
        toolbar.setTitle("设置界面")
    }

}