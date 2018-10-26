package com.viger.myplayer.net

import com.viger.myplayer.util.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * 网络请求管理类
 */
class NetManager private constructor(){
    val client by lazy {
        OkHttpClient()
    }
    companion object {
        val manager by lazy { NetManager() }
    }

    fun <RESPONSE>sendRequest(req: MRequest<RESPONSE>) {
        val request = Request.Builder()
                .url(req.url)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object :  Runnable{
                    override fun run() {
                        //homeView.onError(e?.message)
                        req.handler.onError(req.type, e?.message)
                    }
                })
            }
            override fun onResponse(call: Call, response: Response) {
                val result = response.body()?.string()
                val parseResult = req.parseResult(result)
                //刷新列表
                ThreadUtil.runOnMainThread(object : Runnable{
                    override fun run() {
                        //homeView.loadSuccess(list)
                        req.handler.onSuccess(req.type, parseResult)
                    }
                })
            }
        })
    }


}