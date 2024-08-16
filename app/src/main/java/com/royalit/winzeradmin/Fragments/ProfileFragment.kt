package com.royalit.winzeradmin.Fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.royalit.winzeradmin.Activitys.AboutUsActivity
import com.royalit.winzeradmin.Activitys.BankDetailsActivity
import com.royalit.winzeradmin.Activitys.ContactUsActivity
import com.royalit.winzeradmin.Activitys.EditProfileActivity
import com.royalit.winzeradmin.Activitys.FaqsActivity
import com.royalit.winzeradmin.Activitys.KFCDocumentsActivity
import com.royalit.winzeradmin.Activitys.OpenTicketActivity
import com.royalit.winzeradmin.Activitys.PrivacyPolicyActivity
import com.royalit.winzeradmin.Activitys.ProfileActivity
import com.royalit.winzeradmin.Activitys.TermsAndConditionsActivity
import com.royalit.winzeradmin.Authentications.LoginActivity
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.databinding.FragmentProfileBinding
import com.royalit.winzeradmin.databinding.FragmentSupportBinding

class ProfileFragment : Fragment(), View.OnClickListener  {

    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        callEmiDetailsApi()
//        callPendingInvoiceApi()

        init()
    }

    private fun init() {
        binding.linearPersonalInfo.setOnClickListener(this)
        binding.linearKFCDocuments.setOnClickListener(this)
        binding.linearBankDetails.setOnClickListener(this)
        binding.linearAboutUs.setOnClickListener(this)
        binding.linearTermsAndConditions.setOnClickListener(this)
        binding.linearPrivacyPolicy.setOnClickListener(this)
        binding.linearFaq.setOnClickListener(this)
        binding.linearContactUS.setOnClickListener(this)
        binding.linearLogOut.setOnClickListener(this)
        binding.imgEdit.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgEdit -> {
                startActivity(Intent(activity, EditProfileActivity::class.java))
            }

            R.id.linearPersonalInfo -> {
                startActivity(Intent(activity, ProfileActivity::class.java))
//                startActivity(Intent(activity, OpenTicketActivity::class.java))
            }

            R.id.linearKFCDocuments -> {
                startActivity(Intent(activity, KFCDocumentsActivity::class.java))
            }

            R.id.linearBankDetails -> {
                startActivity(Intent(activity, BankDetailsActivity::class.java))
            }

            R.id.linearAboutUs -> {
                startActivity(Intent(activity, AboutUsActivity::class.java))
            }

            R.id.linearTermsAndConditions -> {
                startActivity(Intent(activity, TermsAndConditionsActivity::class.java))
            }

            R.id.linearPrivacyPolicy -> {
                startActivity(Intent(activity, PrivacyPolicyActivity::class.java))
            }

            R.id.linearFaq -> {
                startActivity(Intent(activity, FaqsActivity::class.java))
            }

            R.id.linearContactUS -> {
                startActivity(Intent(activity, ContactUsActivity::class.java))
            }

            R.id.linearLogOut -> {
                logOut()
            }

        }
    }

    private fun logOut() {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setMessage("Are you sure you want to logout?")
        builder.setTitle("Alert!")
        builder.setCancelable(false)
        builder.setPositiveButton(
            "Yes"
        ) { dialog: DialogInterface?, which: Int ->
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            requireActivity().finishAffinity() // Close all activities in the app
        }
        builder.setNegativeButton(
            "No"
        ) { dialog: DialogInterface, which: Int ->
            dialog.cancel()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }


}