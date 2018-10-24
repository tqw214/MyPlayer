package com.viger.myplayer.net

class NetManager private constructor(){

    companion object {
        val manager by lazy { NetManager() }
    }

    fun <RESPONSE>sendRequest(req: MRequest<RESPONSE>) {

    }


}