package com.appabilities.complainmanagementsystem.screens.registration_module.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseFragment

class RegisterFragment : BaseFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.register_fragment,container,false)
    }


}