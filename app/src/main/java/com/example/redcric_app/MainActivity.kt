package com.example.redcric_app

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private val homeFragment = HomeFragment() // Rename the fragments accordingly
    private val myContestFragment = MyContestFragment()
    private val accountFragment = AccountFragment()
    private val moreFragment = MoreFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        // Load the initial fragment
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, homeFragment).commit()

        // Set up BottomNavigationView icons' color changes and text color
        setUpBottomNavigationIcons()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, homeFragment).commit()
                return true
            }
            R.id.menu_my_contest -> {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, myContestFragment).commit()
                return true
            }
            R.id.menu_account -> {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, accountFragment).commit()
                return true
            }
            R.id.menu_more -> {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, moreFragment).commit()
                return true
            }
        }
        return false
    }

    private fun setUpBottomNavigationIcons() {
        val menu = bottomNavigationView.menu

        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
            val colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.darker_gray))
            bottomNavigationView.itemTextColor = colorStateList
            // Set icon tint list
            val icon = menuItem.icon
            val iconTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    this,
                    if (menuItem.itemId == R.id.menu_home) R.color.red else R.color.white
                )
            )
            if (icon != null) {
                icon.setTintList(iconTintList)
            }
        }

        // Set always visible text color for all menu items
        val colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.darker_gray))
        bottomNavigationView.itemTextColor = colorStateList
    }
}


