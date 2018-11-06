package com.viger.myplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.YueDanBean
import com.viger.myplayer.widget.YueDanItemView

class YueDanAdapter : RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {

    private var list = ArrayList<YueDanBean.PlayListsBean>()

    fun updateList(list: List<YueDanBean.PlayListsBean>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: YueDanHolder, p1: Int) {
        val data = list.get(p1)
        val view = p0.itemView as YueDanItemView
        view.setData(data)
    }


    class YueDanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}