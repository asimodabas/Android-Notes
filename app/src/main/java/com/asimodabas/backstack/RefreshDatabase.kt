package com.asimodabas.backstack

import android.content.Context
import android.content.SharedPreferences
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) : Worker(
    context,
    workerParams
) {
    override fun doWork(): Result {
        val getData = inputData
        val myNumber = getData.getInt("intKey", 0)
        refreshDatabase(myNumber)
        return Result.success()
    }

    private fun refreshDatabase(myNumber: Int) {
        val sharedPreferences =
            context.getSharedPreferences("com.asimodabas.backstack", Context.MODE_PRIVATE)
        var myyNumber = sharedPreferences.getInt("number", 0)
        myyNumber = myNumber + myNumber
        println(myyNumber)
        sharedPreferences.edit().putInt("number", myyNumber).apply()
    }
}