package com.appabilities.complainmanagementsystem.screens.complain_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.appabilities.complainmanagementsystem.R
import com.appabilities.complainmanagementsystem.base.BaseFragment
import com.appabilities.complainmanagementsystem.databinding.ActivityItemComplainBinding
import com.appabilities.complainmanagementsystem.databinding.ComplainFragmentBinding
import com.appabilities.complainmanagementsystem.screens.models.ComplainModel
import com.thetechnocafe.gurleensethi.liteutils.RecyclerAdapterUtil
import kotlinx.android.synthetic.main.toolbar.view.*

class ComplainFragment : BaseFragment() {

    lateinit var bi: ComplainFragmentBinding
    lateinit var mAdapter: RecyclerAdapterUtil<ComplainModel>
    var complainList: List<ComplainModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bi = DataBindingUtil.inflate(inflater, R.layout.complain_fragment, container, false)
        setupViews()
        return bi.root
    }

    fun setupViews() {
        bi.toolbar.title.text = getString(R.string.my_complains)

        complainList += ComplainModel("Test Complain - 1", "1", "2-2-2002","Shortage of Chairs. Please resolve this isssue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 2", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")
        complainList += ComplainModel("Test Complain - 10", "2", "3-3-2003","Shortage of Place. Please resolve this issue ASAP")

        mAdapter = RecyclerAdapterUtil(activity!!, complainList, R.layout.activity_item_complain)
        mAdapter.addOnDataBindListener { itemView, item, position, innerViews ->
            val binding = DataBindingUtil.bind<ActivityItemComplainBinding>(itemView)
            binding!!.item = item
            binding!!.executePendingBindings()
            binding!!.textView15.text = item.complain_id
            binding!!.textView17.text = item.complain_name
            binding!!.textView16.text = item.complain_date
            binding!!.textView18.text = item.complain_desc
        }
        mAdapter.addOnClickListener { item, position ->
            val bundle = Bundle()
            bundle.putString("complain_id",item.complain_id)
            bundle.putString("complain_name",item.complain_name)
            bundle.putString("complain_date",item.complain_date)
            bundle.putString("complain_desc",item.complain_desc)

            val navController = Navigation.findNavController(activity!!, R.id.bottomNavFragment)
            navController.navigate(R.id.action_bottomNavFragmentOne_to_complainDetailsActivity,bundle)
        }
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        bi.recyclerComplain.layoutManager = layoutManager
        bi.recyclerComplain.addItemDecoration(DividerItemDecoration(bi.recyclerComplain.context, layoutManager.orientation))
        bi.recyclerComplain.adapter = mAdapter

        bi.add.setOnClickListener {
            val navController = Navigation.findNavController(activity!!, R.id.bottomNavFragment)
            navController.navigate(R.id.action_bottomNavFragmentOne_to_addComplainActivity)
        }

    }

}