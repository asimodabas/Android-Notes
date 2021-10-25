package com.asimodabas.backstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        toolbar2.title = "Navigation Drawer"
        setSupportActionBar(toolbar2)
        val toggle = ActionBarDrawerToggle(this,drawer,toolbar2,0,0)
    drawer.addDrawerListener(toggle)
        toggle.syncState()
    }
}