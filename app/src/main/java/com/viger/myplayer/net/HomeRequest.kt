package com.viger.myplayer.net

import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.util.URLProviderUtils

class HomeRequest(offset:Int, handler:ResponseHandler<List<HomeItemBean>>) :
        MRequest<List<HomeItemBean>>(URLProviderUtils.getHomeUrl(offset,20),
                handler) {
}