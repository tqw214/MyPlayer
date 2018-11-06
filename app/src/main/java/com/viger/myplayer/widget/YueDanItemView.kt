package com.viger.myplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.itheima.player.model.bean.YueDanBean
import com.viger.myplayer.R
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * 自定义悦单item布局
 */
class YueDanItemView : RelativeLayout {

    fun setData(data: YueDanBean.PlayListsBean) {
        title.text = data.title
        author_name.text = data.creator?.nickName
        count.text = data.videoCount.toString()
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

}