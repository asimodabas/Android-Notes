package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_c.*
import kotlinx.android.synthetic.main.activity_d.*
import kotlinx.android.synthetic.main.fragmentbirinci.*

class ActivityD : AppCompatActivity(), SearchView.OnQueryTextListener {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        buttonGotoE.setOnClickListener {
            startActivity(Intent(this@ActivityD, NavigationDrawer::class.java))
        }

        buttonSecim.setOnClickListener {

            val barcelonaDurum = radioButtonBarcelona.isChecked
            val galatasarayDurum = radioButtonGalatasaray.isChecked
            val JavaDurum = checkBoxJava.isChecked
            val kotlinDurum = checkBoxKotlin.isChecked

            var x = ""

            if (barcelonaDurum) {
                x += "\n" + "Barcelona secildi."
            }
            if (galatasarayDurum) {
                x += "\n" + "Galatasaray secildi."
            }
            if (JavaDurum) {
                x += "\n" + "Java secildi."
            }
            if (kotlinDurum) {
                x += "\n" + "Kotlin secildi."
            }

            textView8.text = x
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@ActivityD, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_arama, menu)
        val item = menu.findItem(R.id.actionAra)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            Log.e("onQueryTextChange", newText)
        }

        Log.e("onQueryTextChange", newText!!)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.e("onQueryTextSubmit", query!!)

        return true
    }
}

