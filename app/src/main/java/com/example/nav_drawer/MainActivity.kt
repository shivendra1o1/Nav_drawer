package com.example.nav_drawer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.app.ActionBarDrawerToggle

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.nav_drawer.databinding.ActivityMainBinding
import com.example.nav_drawer.databinding.HeaderBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private  lateinit var  binding : ActivityMainBinding
    private  lateinit var drawer : DrawerLayout
    private lateinit var toggle :ActionBarDrawerToggle
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)


        val nav_view = binding.navigationView

        // Set up the ActionBarDrawerToggleva
         drawer = binding.drawerLayout
         toggle = ActionBarDrawerToggle(
            this,
            drawer,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        // Set up the NavigationView
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        

        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the home action
                Toast.makeText(this,"Clicked", Toast.LENGTH_LONG).show()
            }

            R.id.nav_profile -> {
                // Handle the profile action
                Toast.makeText(this,"Clicked", Toast.LENGTH_LONG).show()

            }

            R.id.nav_settings -> {
                // Handle the settings action
                Toast.makeText(this,"Clicked", Toast.LENGTH_LONG).show()

            }
        }

        // Close the navigation drawer

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        // Close the navigation drawer if it's open, instead of exiting the app
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)

        }
    }
}