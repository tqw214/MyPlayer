package com.viger.myplayer.view

import com.itheima.player.model.bean.HomeItemBean

interface HomeView {
    abstract fun onError(message: String?)
    abstract fun loadMore(list: List<HomeItemBean>)
    abstract fun loadSuccess(list: List<HomeItemBean>)
}