package com.royalit.winzeradmin.Activitys

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.Utils.ViewController
import com.royalit.winzeradmin.databinding.ActivityAboutUsBinding
import com.royalit.winzeradmin.databinding.ActivityOpenTicketBinding

class OpenTicketActivity : AppCompatActivity() {

    val binding: ActivityOpenTicketBinding by lazy {
        ActivityOpenTicketBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewController.changeStatusBarColor(
            this,
            ContextCompat.getColor(this, R.color.statusBarBg),
            false
        )

        inits()
    }

    private fun inits() {
        binding.includedHeaderLL.backButtonIV.setOnClickListener {
            finish()
        }
        binding.cardAdd.setOnClickListener {
            showPopup()
        }
    }


    private fun showPopup() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_ticket)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


        val editSubject = dialog.findViewById<EditText>(R.id.editSubject)
        val editComment = dialog.findViewById<EditText>(R.id.editComment)

        val cardSubmit = dialog.findViewById<CardView>(R.id.cardSubmit)
        cardSubmit.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

}