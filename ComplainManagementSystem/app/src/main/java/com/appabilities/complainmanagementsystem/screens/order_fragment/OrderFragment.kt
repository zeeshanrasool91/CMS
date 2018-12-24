package com.appabilities.complainmanagementsystem.screens.order_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseFragment
import com.appabilities.complainmanagementsystem.databinding.OrderFragmentBinding
import kotlinx.android.synthetic.main.toolbar.view.*

class  OrderFragment : BaseFragment(){

    lateinit var bi : OrderFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bi = DataBindingUtil.inflate(inflater,R.layout.order_fragment,container,false)
        setUpViews()
        return bi.root
    }

    fun setUpViews(){
        bi.toolbar.title.text = getString(R.string.my_orders)
        bi.txt.text = "Order Fragment"
    }
}