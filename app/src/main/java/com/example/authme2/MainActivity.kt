/*
package com.example.authme2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    private lateinit var mDrawerLayout : DrawerLayout
    private lateinit var mNavigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawerLayout = findViewById(R.id.drawerLayout)
        mNavigationView = findViewById(R.id.navView)


        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container, GenerateCode.newInstance()).commit()

        toggle =
            ActionBarDrawerToggle(this@MainActivity, mDrawerLayout, R.string.open, R.string.close)
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mNavigationView.setNavigationItemSelectedListener {
            val id: Int = it.getItemId()

            //to prevent current item select over and over

            //to prevent current item select over and over
            if (it.isChecked()) {
                mDrawerLayout.closeDrawer(GravityCompat.START)
                return@setNavigationItemSelectedListener false
            }
            when (it.itemId) {
                R.id.firstItem -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container, GenerateCode.newInstance()).commit()
                    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        mDrawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
                R.id.secondtItem -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container, InOffice.newInstance()).commit()
                    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        mDrawerLayout.closeDrawer(GravityCompat.START)
                    }
                    //transaction.add(R.id.LinearLayout1, firstFragment).replace()
                }
                R.id.thirdItem -> {
                    Toast.makeText(this@MainActivity, "third Item Clicked", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}*/
