package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        GoToD.setOnClickListener {
            startActivity(Intent(this@ActivityC,ActivityD::class.java))

        }

        switch1.setOnCheckedChangeListener { compoundButton, b ->

            if (b){
                Log.e("Switch Açık","ON")
              val girdi  = b.toString()
                textView6Durum.text = girdi.toString()

            }

                else{
                val girdi  = b.toString()
                textView6Durum.text = girdi.toString()
                Log.e("Switch Kapalı","OFF")

            }
            toggleButton.setOnCheckedChangeListener { compoundButton, b ->

                if (b) {
                    Log.e("ToggleButton Açık", "ON")

                } else {
                    Log.e("ToggleButton Kapalı", "OFF")

                }
            }
        }

    }
}