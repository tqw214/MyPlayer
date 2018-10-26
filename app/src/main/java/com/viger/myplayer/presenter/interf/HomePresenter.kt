package com.viger.myplayer.presenter.interf

interface HomePresenter {

    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2
    }

    fun loadDatas()
    abstract fun loadMore(i: Int)
}