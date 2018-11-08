package com.viger.myplayer.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.viger.myplayer.widget.LoadMoreView
import java.util.*

abstract class BaseListAdapter<T,V:View> : RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {

    private var list = ArrayList<T>()

    fun updateList(list: List<T>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: List<T>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        if (viewType == 1) {
            return BaseListHolder(LoadMoreView(parent.context))
        } else {
            return BaseListHolder(getItemView(parent.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: BaseListAdapter.BaseListHolder, position: Int) {
        if (position == list.size) {
            return
        }
        val data = list.get(position)
        val itemView = holder.itemView as V
        //itemView.setData(data)
        refreshItemView(itemView, data)
    }

    abstract fun refreshItemView(itemView: V, data: T)
    abstract fun getItemView(context: Context): View

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {
            return 1
        } else {
            return 0
        }
    }

    class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}