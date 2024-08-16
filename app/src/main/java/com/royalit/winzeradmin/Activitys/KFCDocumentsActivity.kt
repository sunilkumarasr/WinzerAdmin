package com.royalit.winzeradmin.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.Utils.ViewController
import com.royalit.winzeradmin.databinding.ActivityAboutUsBinding
import com.royalit.winzeradmin.databinding.ActivityKfcdocumentsBinding

class KFCDocumentsActivity : AppCompatActivity() {

    val binding: ActivityKfcdocumentsBinding by lazy {
        ActivityKfcdocumentsBinding.inflate(layoutInflater)
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
    }


}