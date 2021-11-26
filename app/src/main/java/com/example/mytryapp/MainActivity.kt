package com.example.mytryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mytryapp.fragment.AppliedFragment
import com.example.mytryapp.fragment.HomeFragment
import com.example.mytryapp.fragment.MoreFragment
import com.example.mytryapp.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btmNav : BottomNavigationView = findViewById(R.id.btm_nav)

        btmNav.setOnNavigationItemSelectedListener(itemlc)
        replaceFragment(HomeFragment())
    }

    val itemlc = BottomNavigationView.OnNavigationItemSelectedListener{
        menuItem ->
        when(menuItem.itemId){
            R.id.navigation_home -> {
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_applied -> {
                replaceFragment(AppliedFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                replaceFragment(MoreFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    fun replaceFragment(frag : Fragment){

        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment,frag)
        ft.commit()
    }
}