package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_d.*
import kotlinx.android.synthetic.main.fragmentbirinci.*

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)



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

    }

