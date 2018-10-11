package com.viger.myplayer.ui.fragment

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viger.myplayer.R
import org.jetbrains.anko.toast

class SettingFragment: PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        val key = preference?.key
        if("clear_cache".equals(key)) {
            toast("点击了清除缓存")
        }
        if("about".equals(key)) {
            toast("点击了关于")
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }

}