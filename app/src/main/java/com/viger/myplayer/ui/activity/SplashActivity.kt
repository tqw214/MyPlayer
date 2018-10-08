package com.viger.myplayer.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.viger.myplayer.R
import com.viger.myplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: BaseActivity(), ViewPropertyAnimatorListener {

    override fun onAnimationCancel(p0: View?) {

    }

    override fun onAnimationStart(p0: View?) {

    }

    override fun onAnimationEnd(p0: View?) {
        //进入主界面activity
//        startActivity(intentFor<MainActivity>())
//        finish()
        startActivityAndFinish<MainActivity>()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        super.initData()
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setDuration(2000).setListener(this)
    }

}