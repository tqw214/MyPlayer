package com.viger.myplayer.util

import android.support.v4.app.Fragment
import com.viger.myplayer.R
import com.viger.myplayer.ui.fragment.HomeFragment
import com.viger.myplayer.ui.fragment.MvFragment
import com.viger.myplayer.ui.fragment.VBangFragment
import com.viger.myplayer.ui.fragment.YueDanFragment

class FragmentUtil private constructor(){

    val homeFragment by lazy {
        HomeFragment()
    }

    val mvFragment by lazy {
        MvFragment()
    }

    val vBangFragment by lazy {
        VBangFragment()
    }

    val yueDanFragment by lazy {
        YueDanFragment()
    }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun getFragment(tabId:Int): Fragment {
        when(tabId) {
            R.id.tab_home->return homeFragment
            R.id.tab_mv->return mvFragment
            R.id.tab_vbang->return vBangFragment
            R.id.tab_yuedan->return yueDanFragment
        }
        return Fragment()
    }

}