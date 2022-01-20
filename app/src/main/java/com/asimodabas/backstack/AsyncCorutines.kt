package com.asimodabas.backstack

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){



    var userName = ""
    var userAge = 0

    runBlocking {

        /*
        launch {
        val downloadName = downloadName()
            userName = downloadName
        }
        launch {
            val downloadAge = downloadAge()
            userAge = downloadAge
        }
        launch {
        println("${userName} ${userAge}")
        }
         */

        val downloadName = async {
            downloadName()
        }
        val downloadAge = async {
            downloadAge()
        }
        userName = downloadName.await()
        userAge = downloadAge.await()

        println("${userName} ${userAge}")
    }

}
suspend fun downloadName() : String{
    delay(2000)
    val userName = "Asim:"
    println("Username Download")
    return userName
}
suspend fun downloadAge() : Int{
    delay(4000)
    val userAge = 60
    println("Userage Download")
    return userAge

}

