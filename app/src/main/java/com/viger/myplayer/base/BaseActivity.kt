package com.viger.myplayer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

/**
 * BaseActivity
 */
abstract class BaseActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    open protected fun initData() {

    }

    open protected fun initListener() {

    }

    abstract fun getLayoutId():Int

    protected fun myToast(msg: String) {
        runOnUiThread {
            toast(msg)
        }
    }

    inline fun <reified T:BaseActivity> startActivityAndFinish() {
        startActivity(intentFor<T>())
        finish()
    }


}