package com.appabilities.complainmanagementsystem.screens.registration_module.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseFragment
import com.appabilities.complainmanagementsystem.databinding.LoginFragmentBinding

class LoginFragment : BaseFragment() {

    lateinit var bi: LoginFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bi = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        setupViews()
        return bi.root
    }

    fun setupViews() {
        val navController = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)

        bi.regTxt.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }

        bi.loginbtn.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_bottomNavActivity)
        }
    }

}