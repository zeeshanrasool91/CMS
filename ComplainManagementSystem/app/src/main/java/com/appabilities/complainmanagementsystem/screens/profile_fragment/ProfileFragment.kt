package com.appabilities.complainmanagementsystem.screens.profile_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseActivity
import com.appabilities.complainmanagementsystem.base.BaseFragment
import com.appabilities.complainmanagementsystem.databinding.OrderFragmentBinding
import com.appabilities.complainmanagementsystem.databinding.ProfileFragmentBinding
import kotlinx.android.synthetic.main.toolbar.view.*


class ProfileFragment : BaseFragment() {

    lateinit var bi : ProfileFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bi = DataBindingUtil.inflate(inflater,R.layout.profile_fragment,container,false)
        setUpViews()
        return bi.root
    }

    fun setUpViews(){
        bi.toolbar.title.text = getString(R.string.my_profile)
        bi.fname.setText("Muhammad")
        bi.lname.setText("Mohsin")
        bi.mob.setText("0320-92835497")
        bi.email.setText("m.mohsin@symmetrygroup.biz")
    }
}