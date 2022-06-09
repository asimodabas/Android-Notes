package com.asimodabas.backstack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_c.*
import kotlinx.android.synthetic.main.activity_d.*
import java.io.*

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        buttonAlert.setOnClickListener {
            val ad = AlertDialog.Builder(this)

            ad.setMessage("Menü seçenekleri açılacak")
            ad.setTitle("Menü Uyarısı")
            ad.setIcon(R.drawable.ic_baseline_warning_24)
            ad.setPositiveButton("Tamam") { DialogInterface, i ->
                Toast.makeText(this, "Tamam Seçildi", Toast.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("İptal") { DialogInterface, i ->
                Toast.makeText(this, "İptal Seçildi", Toast.LENGTH_SHORT).show()
            }
            ad.create().show()
        }

        GoToD.setOnClickListener {
            startActivity(Intent(this@ActivityC, ActivityD::class.java))
        }

        switch1.setOnCheckedChangeListener { compoundButton, b ->

            if (b) {
                Log.e("Switch Açık", "ON")
                val girdi = b.toString()
                textView6Durum.text = girdi.toString()

            } else {
                val girdi = b.toString()
                textView6Durum.text = girdi.toString()
                Log.e("Switch Kapalı", "OFF")
            }
            toggleButton.setOnCheckedChangeListener { compoundButton, b ->

                if (b) {
                    Log.e("ToggleButton Açık", "ON")
                    val girdi = b.toString()
                    textView6Durum.text = girdi.toString()
                } else {
                    Log.e("ToggleButton Kapalı", "OFF")
                    val girdi = b.toString()
                    textView6Durum.text = girdi.toString()
                    Log.e("Switch Kapalı", "OFF")
                }
            }
        }

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                val seekbardurum = p1.toString()
                textView9.text = seekbardurum
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        buttonYaz.setOnClickListener {
            hariciYaz()
            //    dahiliYaz()
        }
        buttonSil.setOnClickListener {
            hariciSil()
            //    dahiliOku()
        }
        buttonOku.setOnClickListener {
            hariciOku()
            //    dahiliSil()
        }
    }

    fun hariciYaz() {
        try {
            val yol = applicationContext.getExternalFilesDir(null)?.absolutePath
            val dosya = File(yol, "dosyam.txt")
            if (!dosya.exists()) {
                dosya.createNewFile()
            }
            val fw = FileWriter(dosya)
            val yazici = BufferedWriter(fw)
            yazici.write(editTextGirdi.text.toString())

            yazici.flush()
            yazici.close()
            fw.close()

            editTextGirdi.setText("")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hariciOku() {
        try {
            val yol = applicationContext.getExternalFilesDir(null)?.absolutePath
            val dosya = File(yol, "dosyam.txt")

            val fr = FileReader(dosya)
            val okuyucu = BufferedReader(fr)

            val sb = StringBuilder()
            var satir: String? = null

            while ({ satir = okuyucu.readLine();satir }() != null) {
                sb.append(satir + "\n")
            }
            okuyucu.close()
            editTextGirdi.setText(sb.toString())

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hariciSil() {
        val yol = applicationContext.getExternalFilesDir(null)?.absolutePath
        val dosya = File(yol, "dosyam.txt")

        dosya.delete()
    }

    //Dahili depolama aktif etmek için
    fun dahiliYaz() {
        try {
            val fo = openFileOutput("dosyam.txt", Context.MODE_PRIVATE)
            val yazici = OutputStreamWriter(fo)
            yazici.write(editTextGirdi.text.toString())
            yazici.close()
            editTextGirdi.setText("")
        } catch (e: Exception) {
        }
    }

    //Dahili depolama aktif etmek için
    fun dahiliOku() {
        try {
            val fi = openFileInput("dosyam.txt")
            val isr = InputStreamReader(fi)
            val okuyucu = BufferedReader(isr)

            val sb = StringBuilder()
            var satir: String? = null

            while ({ satir = okuyucu.readLine();satir }() != null) {
                sb.append(satir + "\n")
            }
            okuyucu.close()
            editTextGirdi.setText(sb.toString())
        } catch (e: Exception) {
        }
    }

    //Dahili depolama aktif etmek için
    fun dahiliSil() {
        val dir = filesDir
        var dosya = File(dir, "dosyam.txt")
        dosya.delete()
    }
}

