# Kotlin Coroutines

COROUTINE - async non-blocking job (can run on the same thread ad other coroutines without blocking)

* library kotlinx.coroutines
* runs in a context
* Ktor uses them through the framework -> good performance
* coroutine function is indicated by "suspend" decorator
* suspend functions can be only run from suspend a function
* a coroutine function is usually started by lunch function in default context
* a coroutine can be run (tested) by the main function by using the run-blocking function 