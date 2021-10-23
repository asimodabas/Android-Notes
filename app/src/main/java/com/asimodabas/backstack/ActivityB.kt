package com.asimodabas.backstack

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)



        goToC.setOnClickListener {
            startActivity(Intent(this@ActivityB, ActivityC::class.java))

            val girilen = editTextGirilen.text.toString()
            textViewAlınan.text = girilen.toString()
        }

        buttonBasla.setOnClickListener {

            val adres = Uri.parse("Android.resource://" + packageName + "/" + R.raw.video)

            videoView.setVideoURI(adres)
            videoView.start()
        }
        buttonDur.setOnClickListener {
            videoView.stopPlayback()
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_ayarlar -> {
                Toast.makeText(this, "Ayarlara basildi", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_cikis -> {
                Toast.makeText(this, "Cikisa basildi", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_bilgi -> {
                Toast.makeText(this, "Bilgiye basildi", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}