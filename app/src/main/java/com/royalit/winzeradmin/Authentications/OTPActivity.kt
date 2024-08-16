package com.royalit.winzeradmin.Authentications

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.royalit.winzeradmin.Activitys.DashBoardActivity
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.Utils.ViewController
import com.royalit.winzeradmin.databinding.ActivityOtpactivityBinding

class OTPActivity : AppCompatActivity() {

    val binding: ActivityOtpactivityBinding by lazy {
        ActivityOtpactivityBinding.inflate(layoutInflater)
    }

    fun AppCompatEditText.showKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        this.requestFocus()
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }

    lateinit var mobileNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewController.changeStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary), false)
        mobileNumber= intent.getStringExtra("mobileNumber").toString()

        inti()
    }

    private fun inti() {
        binding.enterNumber.text =  getString(R.string.please_enter_the_OTP_sent_to_) + " +91 ${mobileNumber}"

        var count = 0
        fun setFocusable(){
            count++
            binding.pinEdit1.isFocusable = true
            binding.pinEdit1.isFocusableInTouchMode = true
            binding.pinEdit2.isFocusable = true
            binding.pinEdit2.isFocusableInTouchMode = true
            binding.pinEdit3.isFocusable = true
            binding.pinEdit3.isFocusableInTouchMode = true
            binding.pinEdit4.isFocusable = true
            binding.pinEdit4.isFocusableInTouchMode = true
        }
        binding.pinEdit1.setOnClickListener {
            if(count==0){
                setFocusable()
                binding.pinEdit1.requestFocus()
                binding.pinEdit1.showKeyboard()
            }
        }
        binding.pinEdit2.setOnClickListener {
            if(count==0){
                setFocusable()
                binding.pinEdit2.requestFocus()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.pinEdit2.showKeyboard()
                },100)

            }
        }
        binding.pinEdit3.setOnClickListener {
            if(count==0){
                setFocusable()
                binding.pinEdit3.requestFocus()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.pinEdit3.showKeyboard()
                },100)

            }
        }
        binding.pinEdit4.setOnClickListener {
            if(count==0){
                setFocusable()
                binding.pinEdit4.requestFocus()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.pinEdit4.showKeyboard()
                },100)

            }
        }
        //change to other box
        binding.pinEdit1.addTextChangedListener {
            if (it?.toString()?.length == 1) binding.pinEdit2.requestFocus()
        }
        binding.pinEdit2.addTextChangedListener {
            if (it?.toString()?.length == 1) binding.pinEdit3.requestFocus() else binding.pinEdit1.requestFocus()
        }
        binding.pinEdit3.addTextChangedListener {
            if (it?.toString()?.length == 1) binding.pinEdit4.requestFocus() else binding.pinEdit2.requestFocus()
        }
        binding.pinEdit4.addTextChangedListener {
            if ((it?.toString()?.length?:0)<1) binding.pinEdit3.requestFocus()
        }

        binding.cardLogin.setOnClickListener {
            if(validateOtp()){
                startActivity(Intent(this@OTPActivity, DashBoardActivity::class.java))
            }else{
                ViewController.showToast(this@OTPActivity,"Please enter valid otp")
            }
        }

    }

    private fun validateOtp():Boolean{
        val pin1 = binding.pinEdit1.editableText.trim().toString()
        val pin2 = binding.pinEdit2.editableText.trim().toString()
        val pin3 = binding.pinEdit3.editableText.trim().toString()
        val pin4 = binding.pinEdit4.editableText.trim().toString()
        return  pin1.isNotEmpty() && pin2.isNotEmpty() && pin3.isNotEmpty() && pin4.isNotEmpty()
    }

}