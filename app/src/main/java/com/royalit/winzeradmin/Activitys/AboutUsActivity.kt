package com.royalit.winzeradmin.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.Utils.ViewController
import com.royalit.winzeradmin.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

    val binding: ActivityAboutUsBinding by lazy {
        ActivityAboutUsBinding.inflate(layoutInflater)
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