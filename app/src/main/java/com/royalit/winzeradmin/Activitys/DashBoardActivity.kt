package com.royalit.winzeradmin.Activitys

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.royalit.winzeradmin.Authentications.LoginActivity
import com.royalit.winzeradmin.Fragments.HomeFragment
import com.royalit.winzeradmin.Fragments.OrdersFragment
import com.royalit.winzeradmin.Fragments.ProfileFragment
import com.royalit.winzeradmin.Fragments.SupportFragment
import com.royalit.winzeradmin.R
import com.royalit.winzeradmin.Utils.ViewController
import com.royalit.winzeradmin.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity(), View.OnClickListener  {


    val binding: ActivityDashBoardBinding by lazy {
        ActivityDashBoardBinding.inflate(layoutInflater)
    }

    private lateinit var bottomNavigationView: BottomNavigationView

    //fragments
    private val homeFragment = HomeFragment()
    private val ordersFragment = OrdersFragment()
    private val profileFragment = ProfileFragment()
    private val supportFragment = SupportFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewController.changeStatusBarColor(
            this,
            ContextCompat.getColor(this, R.color.statusBarBg),
            false
        )


        DrawarMenu()
        bottomMenu()

        binding.imgMenu.setOnClickListener{
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.imgNotification.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgNotification -> {
                startActivity(Intent(this@DashBoardActivity, NotificationActivity::class.java))
            }
        }
    }

    private fun DrawarMenu() {
        binding.navView.setNavigationItemSelectedListener {  menuItem ->
            when (menuItem.itemId) {
                R.id.navHome -> {
                    startActivity(Intent(this@DashBoardActivity, DashBoardActivity::class.java))
                    true
                }
                R.id.navYourOrders -> {
                    startActivity(Intent(this@DashBoardActivity, OrdersActivity::class.java))
                    true
                }
                R.id.navMyAccount -> {
                    startActivity(Intent(this@DashBoardActivity, ProfileActivity::class.java))
                    true
                }
//                R.id.navAddressBook -> {
//                    startActivity(Intent(this@DashBoardActivity, AddressBookActivity::class.java))
//                    true
//                }
//                R.id.navContactUs -> {
//                    startActivity(Intent(this@DashBoardActivity, ContactUsActivity::class.java))
//                    true
//                }
                R.id.navSignOut -> {
                    logOut()
                    true
                }
                else -> false
            }
        }
    }


    private fun logOut() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to logout?")
        builder.setTitle("Alert!")
        builder.setCancelable(false)
        builder.setPositiveButton(
            "Yes"
        ) { dialog: DialogInterface?, which: Int ->
            startActivity(Intent(this@DashBoardActivity, LoginActivity::class.java))
            finishAffinity() // Close all activities in the app
        }
        builder.setNegativeButton(
            "No"
        ) { dialog: DialogInterface, which: Int ->
            dialog.cancel()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }


    private fun bottomMenu() {
        replaceFragment(homeFragment)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        // Set listener for item selection
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true

            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                    true
                }

                R.id.orders -> {
                    replaceFragment(ordersFragment)
                    true
                }

                R.id.profile -> {
                    replaceFragment(profileFragment)
                    true
                }

                R.id.support -> {
                    replaceFragment(supportFragment)
                    true
                }

                else -> false
            }
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }


    override fun onBackPressed() {
        super.onBackPressed()

        finishAffinity()

    }



}