package com.viger.myplayer.view

import com.itheima.player.model.bean.YueDanBean

interface YueDanView {

    fun onError(message: String?)
    fun loadSuccess(response: YueDanBean)
    fun loadMore(response: YueDanBean)

}