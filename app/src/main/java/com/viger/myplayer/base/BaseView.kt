package com.viger.myplayer.base

interface BaseView<T> {
    abstract fun onError(message: String?)
    abstract fun loadMore(list: T)
    abstract fun loadSuccess(list: T)
}