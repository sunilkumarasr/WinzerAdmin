package com.royalit.winzeradmin.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.royalit.winzeradmin.Activitys.EditProfileActivity
import com.royalit.winzeradmin.Activitys.OrderDetailsActivity
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.databinding.FragmentOrdersBinding
import com.royalit.winzeradmin.databinding.FragmentSupportBinding

class OrdersFragment : Fragment() {

    private lateinit var binding: FragmentOrdersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrdersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        callEmiDetailsApi()
//        callPendingInvoiceApi()

        binding.linearOrderDetails.setOnClickListener {
            startActivity(Intent(activity, OrderDetailsActivity::class.java))
        }
    }

}