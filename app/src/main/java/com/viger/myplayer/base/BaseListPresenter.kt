package com.viger.myplayer.base

interface BaseListPresenter {

    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2
    }

    fun loadDatas()
    abstract fun loadMore(i: Int)
    //解绑view
    fun destoryView()

}