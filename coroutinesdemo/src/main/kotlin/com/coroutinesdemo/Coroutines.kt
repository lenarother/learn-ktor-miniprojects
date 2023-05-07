package com.coroutinesdemo

import kotlinx.coroutines.*
import kotlin.random.Random

fun main(args: Array<String>) = runBlocking {
    withContext(Dispatchers.IO){
        repeat(100_000){
            GlobalScope.launch{
                firstcoroutine(it)
            }
        }
        println("End of context")
    }
    println("End of main function")

}


suspend fun firstcoroutine(id: Int){
    delay(Random.nextLong()%2000)
    println("first $id")
}