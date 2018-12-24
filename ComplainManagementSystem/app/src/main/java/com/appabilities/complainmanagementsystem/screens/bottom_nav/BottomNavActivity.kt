package com.appabilities.complainmanagementsystem.screens.bottom_nav

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseActivity
import kotlinx.android.synthetic.main.activity_bottom_nav.*
import androidx.navigation.ui.setupWithNavController

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import android.content.Intent




class BottomNavActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        bottomNavigation.setupWithNavController(Navigation.findNavController(this, R.id.bottomNavFragment))
    }


    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}