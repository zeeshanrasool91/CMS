package com.appabilities.complainmanagementsystem.screens.add_complains

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseActivity
import com.appabilities.complainmanagementsystem.databinding.ActivityAddComplainBinding
import kotlinx.android.synthetic.main.toolbar.view.*

class AddComplainActivity : BaseActivity() {

    lateinit var bi: ActivityAddComplainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_add_complain)

        bi.toolbar.title.text = "Add Complains"
        bi.toolbar.back.setOnClickListener {
            onBackPressed()
        }


    }

}