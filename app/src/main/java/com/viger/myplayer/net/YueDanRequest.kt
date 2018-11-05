package com.viger.myplayer.net

import com.itheima.player.model.bean.YueDanBean
import com.viger.myplayer.util.URLProviderUtils

class YueDanRequest(type:Int,offset:Int,handler: ResponseHandler<YueDanBean>) :
        MRequest<YueDanBean>(type, URLProviderUtils.getYueDanUrl(offset,20),handler) {

}