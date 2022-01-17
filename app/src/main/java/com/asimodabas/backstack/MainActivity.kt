package com.asimodabas.backstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragmentbirinci.*
import kotlinx.coroutines.*

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

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.fragment_tutucuu, FragmentBirinci())
        ft.commit()

        fab.setOnClickListener {
            Toast.makeText(this, "Floating Action Button Aktif", Toast.LENGTH_SHORT).show()
        }
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
            popup()
        }

      //runBlocking()
      //globalScope()
      //coroutineScope()
      //nestedCoroutine()
    }


    fun popup() {
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

   fun runBlocking(){
        println("Before")
        kotlinx.coroutines.runBlocking {
            launch {
            delay(2500)
            println("runBlocking")
        } }
        println("After")
    }

    fun globalScope(){
        println("Before")
        GlobalScope
            .launch {
            delay(2500)
            println("globalScope")
        }
        println("After")
    }

    fun coroutineScope(){
        println("Before")
        CoroutineScope(Dispatchers.Default).launch {
            delay(2500)
            println("coroutineScope")
        }
        println("After")
    }

    fun nestedCoroutine(){
        runBlocking {
            launch {
                delay(5000)
                println("runBlocking")
            }
            coroutineScope {
                launch {
                    delay(2500)
                    println("coroutineScope")
                }
            }
        }
    }

}