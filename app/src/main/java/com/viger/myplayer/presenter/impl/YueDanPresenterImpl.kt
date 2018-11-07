package com.viger.myplayer.presenter.impl

import com.itheima.player.model.bean.YueDanBean
import com.viger.myplayer.net.ResponseHandler
import com.viger.myplayer.net.YueDanRequest
import com.viger.myplayer.presenter.interf.YueDanPresenter
import com.viger.myplayer.view.YueDanView

class YueDanPresenterImpl(var yueDanView : YueDanView) : YueDanPresenter, ResponseHandler<YueDanBean> {

    override fun onError(type: Int, msg: String?) {
        yueDanView.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        if(type == YueDanPresenter.TYPE_INIT_OR_REFRESH) {
            yueDanView.loadSuccess(result)
        }else {
            yueDanView.loadMore(result)
        }
    }

    override fun loadDatas() {
        YueDanRequest(YueDanPresenter.TYPE_INIT_OR_REFRESH, 0, this).excute()
    }

    override fun loadMore(i: Int) {
        YueDanRequest(YueDanPresenter.TYPE_LOAD_MORE, i, this).excute()
    }


}