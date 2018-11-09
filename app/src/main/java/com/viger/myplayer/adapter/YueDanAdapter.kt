package com.viger.myplayer.adapter

import android.content.Context
import android.view.View
import com.itheima.player.model.bean.YueDanBean
import com.viger.myplayer.base.BaseListAdapter
import com.viger.myplayer.widget.YueDanItemView

/**
 * YueDanAdapter
 */
class YueDanAdapter : BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>() {

    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.PlayListsBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context): View {
        return YueDanItemView(context)
    }


}