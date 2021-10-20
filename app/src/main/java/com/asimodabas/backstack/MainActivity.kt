package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.fragment_tutucu, FragmentBirinci())
        ft.commit()

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