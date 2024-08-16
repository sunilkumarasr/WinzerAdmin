package com.royalit.winzeradmin.Authentications

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.royalit.winzeradmin.Activitys.TermsAndConditionsActivity
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.Utils.ViewController
import com.royalit.winzeradmin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewController.changeStatusBarColor(
            this,
            ContextCompat.getColor(this, R.color.colorPrimary),
            false
        )


        binding.cardLogin.setOnClickListener {
            if (checkValidation()) {
                startActivity(Intent(this@LoginActivity, OTPActivity::class.java).apply {
                    putExtra("mobileNumber", binding.editNumber.editableText.trim().toString())
                })
            }
        }


        binding.txtTermsAndConditions.setOnClickListener{
            startActivity(Intent(this@LoginActivity, TermsAndConditionsActivity::class.java))
        }

    }


    fun checkValidation(): Boolean {
        var ret = true
        if (!ViewController.hasEditText(binding.editNumber, "Please Enter Mobile Number")) ret = false
        if (!binding.checkbox.isChecked){
            Toast.makeText(applicationContext,"Please agree to continue", Toast.LENGTH_SHORT).show()
            ret = false
        }
        return ret
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}