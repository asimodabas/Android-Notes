package com.asimodabas.backstack

import android.content.Context
import android.content.SharedPreferences
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {
    override fun doWork(): Result {
        refreshDatabase()
        return Result.success()
    }

    private fun refreshDatabase(){
        val sharedPreferences = context.getSharedPreferences("com.asimodabas.backstack",Context.MODE_PRIVATE)
        var myNumber = sharedPreferences.getInt("number",0)
        myNumber = myNumber+ 1
        println(myNumber)
        sharedPreferences.edit().putInt("number",myNumber)
    }
}