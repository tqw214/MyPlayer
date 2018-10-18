package com.viger.myplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.viger.myplayer.R
import com.viger.myplayer.adapter.HomeAdapter
import com.viger.myplayer.base.BaseFragment
import com.viger.myplayer.util.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment : BaseFragment() {

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        super.initListener()
        recycleView.layoutManager = LinearLayoutManager(this.context)
        val adapter = HomeAdapter()
        recycleView.adapter = adapter
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
                Log.d("tag", response.body()?.string())
            }
        })
    }


}