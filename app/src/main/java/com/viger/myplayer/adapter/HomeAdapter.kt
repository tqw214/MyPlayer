package com.viger.myplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.widget.HomeItemView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    fun updateList(list:List<HomeItemBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {

    }

    class HomeHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

}