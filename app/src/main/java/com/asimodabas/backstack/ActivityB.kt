package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_main.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

    goToC.setOnClickListener {
        startActivity(Intent(this@ActivityB,ActivityC::class.java))

        val girilen=editTextGirilen.text.toString()
        textViewAlınan.text = girilen.toString()

    }
    }
}