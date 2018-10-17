package com.viger.myplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.viger.myplayer.widget.HomeItemView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {

    }

    class HomeHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

}