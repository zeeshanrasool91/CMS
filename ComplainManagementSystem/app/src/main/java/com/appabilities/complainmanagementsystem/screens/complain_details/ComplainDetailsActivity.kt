package com.appabilities.complainmanagementsystem.screens.complain_details

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseActivity
import com.appabilities.complainmanagementsystem.databinding.ActivityComplainDetailBinding
import kotlinx.android.synthetic.main.toolbar.view.*

class ComplainDetailsActivity : BaseActivity() {

    lateinit var bi: ActivityComplainDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_complain_detail)
        setupViews()
    }

    fun setupViews() {
        bi.toolbar.title.text = "Complain Details"

        bi.textView2.text = intent.getStringExtra("complain_id")
        bi.textView4.text = intent.getStringExtra("complain_name")
        bi.textView6.text = intent.getStringExtra("complain_date")
        bi.textView8.text = intent.getStringExtra("complain_desc")

        bi.toolbar.back.setOnClickListener {
            onBackPressed()
        }
    }

}