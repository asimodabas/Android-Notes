package com.asimodabas.backstack

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        delay(2000)
        println("run blocking")
        myFunction()
    }

}

suspend fun myFunction() {
    coroutineScope {
        delay(4000)
        println("suspend function")
    }
}