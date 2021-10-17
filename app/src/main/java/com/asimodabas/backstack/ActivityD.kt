package com.asimodabas.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_d.*

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

    }

    //SEÇİLEN SEÇİMİ textView8 de string olarak göstermiyor.
    //SEÇİLEN SEÇİMİ textView8 de string olarak göstermiyor.
    //SEÇİLEN SEÇİMİ textView8 de string olarak göstermiyor.
    //SEÇİLEN SEÇİMİ textView8 de string olarak göstermiyor.
    //SEÇİLEN SEÇİMİ textView8 de string olarak göstermiyor.
    //SEÇİLEN SEÇİMİ textView8 de string olarak göstermiyor.

    override fun onBackPressed() {
        val intent = Intent(this@ActivityD,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)


        buttonSecim.setOnClickListener {
            val javadurum = checkBoxJava.isChecked
            val kotlindurum = checkBoxKotlin.isChecked
            val barcelonadurum = radioButtonBarcelona.isChecked
            val galatasaraydurum = radioButtonGalatasaray.isChecked

        textView8.text = javadurum.toString()
        textView8.text = kotlindurum.toString()
        textView8.text = barcelonadurum.toString()
        textView8.text = galatasaraydurum.toString()

        }

    }
}