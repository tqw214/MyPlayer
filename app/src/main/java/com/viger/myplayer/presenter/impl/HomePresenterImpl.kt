package com.viger.myplayer.presenter.impl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.presenter.interf.HomePresenter
import com.viger.myplayer.util.ThreadUtil
import com.viger.myplayer.util.URLProviderUtils
import com.viger.myplayer.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomePresenterImpl(var homeView:HomeView): HomePresenter {

    override fun loadDatas() {
        //加载数据
        val path = URLProviderUtils.getHomeUrl(0,20)
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(path)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object :  Runnable{
                    override fun run() {
                        homeView.onError(e?.message)
                    }
                })
            }
            override fun onResponse(call: Call, response: Response) {
                val result = response.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
                //刷新列表
                ThreadUtil.runOnMainThread(object : Runnable{
                    override fun run() {
                        homeView.loadSuccess(list)
                    }
                })
            }
        })
    }

    override fun loadMore(offset: Int) {
        //加载更多数据
        val path = URLProviderUtils.getHomeUrl(offset,20)
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(path)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object :  Runnable{
                    override fun run() {
                        homeView.onError(e?.message)
                    }
                })
            }
            override fun onResponse(call: Call, response: Response) {
                val result = response.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
                //刷新列表
                ThreadUtil.runOnMainThread(object : Runnable{
                    override fun run() {
                        homeView.loadMore(list)
                    }
                })
            }
        })
    }
}