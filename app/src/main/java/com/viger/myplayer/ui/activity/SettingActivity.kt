package com.viger.myplayer.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.viger.myplayer.R
import com.viger.myplayer.base.BaseActivity
import com.viger.myplayer.util.ToolBarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(), ToolBarManager {

    override val toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        super.initData()
        initSettingToolbar()
        //判断推动通知有没有选中
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        sp.getBoolean("push", false)


    }

}