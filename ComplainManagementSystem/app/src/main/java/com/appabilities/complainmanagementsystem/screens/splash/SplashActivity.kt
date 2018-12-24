package com.appabilities.complainmanagementsystem.screens.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseActivity
import com.appabilities.complainmanagementsystem.databinding.ActivitySplashBinding
import android.content.Intent
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed
import androidx.navigation.Navigation
import com.appabilities.complainmanagementsystem.MainActivity
import com.appabilities.complainmanagementsystem.screens.bottom_nav.BottomNavActivity
import com.appabilities.complainmanagementsystem.screens.registration_module.RegistrationModuleActivity


class SplashActivity : BaseActivity(), SplashContract.View {

    lateinit var bi: ActivitySplashBinding
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        bi.view = this
        presenter = SplashPresenter(this)
        presenter.initScreen()
    }

    override fun setupViews() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, RegistrationModuleActivity::class.java))
            finish()
        }, 3000)
    }
}
