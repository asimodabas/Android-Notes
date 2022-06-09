package com.asimodabas.backstack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragmentbirinci.*
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data.Builder().putInt("intKey", 1).build()
        val constraints = Constraints.Builder()
            .setRequiresCharging(false) //Example
            .build()

        /*
        val myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            //.setInitialDelay(5,TimeUnit.MICROSECONDS)
            //.addTag("myTag")
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)
         */
        val myWorkRequest: WorkRequest =
            PeriodicWorkRequestBuilder<RefreshDatabase>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .setInputData(data)
                .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id).observe(this,
            Observer {
                if (it.state == WorkInfo.State.RUNNING) {
                    println("Run...")
                } else if (it.state == WorkInfo.State.FAILED) {
                    println("Fail...")
                } else if (it.state == WorkInfo.State.SUCCEEDED) {
                    println("Success...")
                }
            })

        //WorkManager.getInstance(this).cancelAllWork()

        /*

        //Chaining
        val oneTimeRequest : OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()
        WorkManager.getInstance(this).beginWith(oneTimeRequest)
            .then(oneTimeRequest)
            .then(oneTimeRequest)
            .enqueue()

         */

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

    fun runBlocking() {
        println("Before")
        kotlinx.coroutines.runBlocking {
            launch {
                delay(2500)
                println("runBlocking")
            }
        }
        println("After")
    }

    fun globalScope() {
        println("Before")
        GlobalScope
            .launch {
                delay(2500)
                println("globalScope")
            }
        println("After")
    }

    fun coroutineScope() {
        println("Before")
        CoroutineScope(Dispatchers.Default).launch {
            delay(2500)
            println("coroutineScope")
        }
        println("After")
    }

    fun nestedCoroutine() {
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