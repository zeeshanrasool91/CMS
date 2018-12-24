package com.appabilities.complainmanagementsystem.screens.splash

import com.appabilities.complainmanagementsystem.base.BasePresenter


class SplashPresenter(view: SplashContract.View) : BasePresenter<SplashContract.View>(view), SplashContract.Actions {

    override fun initScreen() {
        _view.setupViews()
    }
}