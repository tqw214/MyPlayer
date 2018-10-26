package com.viger.myplayer.presenter.impl

import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.net.HomeRequest
import com.viger.myplayer.net.ResponseHandler
import com.viger.myplayer.presenter.interf.HomePresenter
import com.viger.myplayer.presenter.interf.HomePresenter.Companion.TYPE_INIT_OR_REFRESH
import com.viger.myplayer.presenter.interf.HomePresenter.Companion.TYPE_LOAD_MORE
import com.viger.myplayer.view.HomeView

class HomePresenterImpl(var homeView:HomeView): HomePresenter, ResponseHandler<List<HomeItemBean>> {

    override fun onError(type: Int, msg: String?) {
        homeView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when (type) {
            HomePresenter.TYPE_INIT_OR_REFRESH->homeView.loadSuccess(result)
            HomePresenter.TYPE_LOAD_MORE->homeView.loadMore(result)
        }
    }

    override fun loadDatas() {
        //加载数据
        val request = HomeRequest(TYPE_INIT_OR_REFRESH,0, this).excute()

//        val request = HomeRequest(0, object : ResponseHandler<List<HomeItemBean>>{
//            override fun onError(msg: String?) {
//                homeView.onError(msg)
//            }
//            override fun onSuccess(result: List<HomeItemBean>) {
//                homeView.loadSuccess(result)
//            }
//        }).excute()

        //NetManager.manager.sendRequest(request)

//        val path = URLProviderUtils.getHomeUrl(0,20)
//        val client = OkHttpClient()
//        val request = Request.Builder()
//                .url(path)
//                .get()
//                .build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainThread(object :  Runnable{
//                    override fun run() {
//                        homeView.onError(e?.message)
//                    }
//                })
//            }
//            override fun onResponse(call: Call, response: Response) {
//                val result = response.body()?.string()
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
//                //刷新列表
//                ThreadUtil.runOnMainThread(object : Runnable{
//                    override fun run() {
//                        homeView.loadSuccess(list)
//                    }
//                })
//            }
//        })
    }

    override fun loadMore(offset: Int) {
        //加载更多数据
        val request = HomeRequest(TYPE_LOAD_MORE, offset, this).excute()

        //NetManager.manager.sendRequest(request)

//        val path = URLProviderUtils.getHomeUrl(offset,20)
//        val client = OkHttpClient()
//        val request = Request.Builder()
//                .url(path)
//                .get()
//                .build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainThread(object :  Runnable{
//                    override fun run() {
//                        homeView.onError(e?.message)
//                    }
//                })
//            }
//            override fun onResponse(call: Call, response: Response) {
//                val result = response.body()?.string()
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
//                //刷新列表
//                ThreadUtil.runOnMainThread(object : Runnable{
//                    override fun run() {
//                        homeView.loadMore(list)
//                    }
//                })
//            }
//        })
    }
}