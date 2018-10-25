package com.viger.myplayer.net

/**
 * 网络请求管理类
 */
class NetManager private constructor(){

    companion object {
        val manager by lazy { NetManager() }
    }

    fun <RESPONSE>sendRequest(req: MRequest<RESPONSE>) {

    }


}