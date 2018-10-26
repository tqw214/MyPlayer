package com.viger.myplayer.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

class MRequest<RESPONSE>(val url:String, val handler:ResponseHandler<RESPONSE>) {

    fun parseResult(result: String?): RESPONSE {
        val gson = Gson()
        val type = (this.javaClass.genericSuperclass as ParameterizedType).getActualTypeArguments()[0]
        val list = gson.fromJson<RESPONSE>(result, type)
        return list
    }

}