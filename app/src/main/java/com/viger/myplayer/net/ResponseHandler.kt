package com.viger.myplayer.net

interface ResponseHandler<RESPONSE> {

    fun onError(msg: String)
    fun onSuccess(result: RESPONSE)

}