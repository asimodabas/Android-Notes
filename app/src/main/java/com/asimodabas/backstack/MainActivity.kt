package com.asimodabas.backstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragmentbirinci.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("GirisSayici", Context.MODE_PRIVATE)
        var sayac = sp.getInt("sayac", 0)
        val editor = sp.edit()
        val newValue = sayac + 1
        editor.putInt("sayac", newValue)
        editor.apply()
        textsayac.text = "Programa Giriş Sayısı :$sayac"

        fab.setOnClickListener {
            Toast.makeText(this, "Floating Action Button Aktif", Toast.LENGTH_SHORT).show()
        }

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.fragment_tutucuu, FragmentBirinci())
        ft.commit()


        buttonNormal.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO


        }
        buttonDark.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES


        }
        goToB.setOnClickListener {
            startActivity(Intent(this@MainActivity, ActivityB::class.java))
            Toast.makeText(this, "B'ye geçildi", Toast.LENGTH_SHORT).show()
        }

        buttonMenuAc.setOnClickListener {
            val popup = androidx.appcompat.widget.PopupMenu(this, buttonMenuAc)
            popup.menuInflater.inflate(R.menu.poppup_menu, popup.menu)






            popup.setOnMenuItemClickListener { item ->

                when (item.itemId) {

                    R.id.ActionSil -> {

                        Toast.makeText(this, "Sil Seçildi", Toast.LENGTH_SHORT).show()
                        true


                    }
                    R.id.ActionDüzenle -> {
                        Toast.makeText(this, "Düzenle Seçildi", Toast.LENGTH_SHORT).show()
                        true

                    }
                    else -> {
                        false
                    }

                }


            }
            popup.show()


        }


    }
}