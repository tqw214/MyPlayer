package com.viger.myplayer.adapter

import android.content.Context
import android.view.View
import com.itheima.player.model.bean.HomeItemBean
import com.viger.myplayer.base.BaseListAdapter
import com.viger.myplayer.widget.HomeItemView

/**
 * HomeAdapter
 */
class HomeAdapter: BaseListAdapter<HomeItemBean, HomeItemView>() {

    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context): View {
        return HomeItemView(context)
    }

}