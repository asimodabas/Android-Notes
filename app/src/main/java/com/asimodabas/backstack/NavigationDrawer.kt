package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawer : AppCompatActivity() {

    private lateinit var tempFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        toolbar2.title = "Navigation Drawer"
        setSupportActionBar(toolbar2)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar2, 0, 0)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportFragmentManager.beginTransaction().add(R.id.fragment_tutucuu, fragmentBir()).commit()
        navigation_vieww.setNavigationItemSelectedListener { menuItem ->

            if (menuItem.itemId == R.id.nav_item_birinci) {
                tempFragment = fragmentBir()
            }
            if (menuItem.itemId == R.id.nav_item_ikinci) {
                Toast.makeText(this, "İkinciye Tıklandı", Toast.LENGTH_SHORT).show()
                tempFragment = fragmentİki()
            }
            if (menuItem.itemId == R.id.nav_item_ucuncu) {
                Toast.makeText(this, "Üçüncüye Tıklandı", Toast.LENGTH_SHORT).show()
                tempFragment = fragmentUc()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_tutucuu, tempFragment)
                .commit()
            drawer.closeDrawer(GravityCompat.START)

            true
        }
    }

    override fun onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START)
        } else {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}