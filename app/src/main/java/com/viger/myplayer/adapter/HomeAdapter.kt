package com.viger.myplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.widget.HomeItemView
import com.viger.myplayer.widget.LoadMoreView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    fun updateList(list:List<HomeItemBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list:List<HomeItemBean>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if(viewType == 1) {
            return HomeHolder(LoadMoreView(parent.context))
        }else {
            return HomeHolder(HomeItemView(parent.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if(position == list.size) {
            return
        }
        val data = list.get(position)
        val itemView = holder.itemView as HomeItemView
        itemView.setData(data)
    }

    override fun getItemViewType(position: Int): Int {
        if(position == list.size) {
            return 1
        }else {
            return 0
        }
    }

    class HomeHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

}