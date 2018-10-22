package com.viger.myplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.R
import com.viger.myplayer.adapter.HomeAdapter
import com.viger.myplayer.base.BaseFragment
import com.viger.myplayer.util.ThreadUtil
import com.viger.myplayer.util.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * HomeFragment
 */
class HomeFragment : BaseFragment() {

    val adapter by lazy {
        HomeAdapter()
    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        super.initListener()
        recycleView.layoutManager = LinearLayoutManager(this.context)
        //val adapter = HomeAdapter()
        recycleView.adapter = adapter
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)

    }

    override fun initData() {
        super.initData()
        loadDatas()

    }

    private fun loadDatas() {
        //加载数据
        val path = URLProviderUtils.getHomeUrl(0,20)
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(path)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                myToast("获取数据失败")
            }
            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                val result = response.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
                //刷新列表
                ThreadUtil.runOnMainThread(object : Runnable{
                    override fun run() {
                        adapter.updateList(list)
                    }
                })
            }
        })
    }


}