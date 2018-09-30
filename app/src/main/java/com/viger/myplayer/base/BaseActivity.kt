package com.viger.myplayer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    protected fun initData() {

    }

    protected fun initListener() {

    }

    abstract fun getLayoutId():Int

    protected fun myToast(msg: String) {
        runOnUiThread {
            toast(msg)
        }
    }

}