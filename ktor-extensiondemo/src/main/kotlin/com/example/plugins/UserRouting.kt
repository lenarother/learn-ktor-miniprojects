package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureUserRouting() {
    routing {
        get("/user") {
            call.respondText("User1")
        }
        post("/user"){
            call.respondText("The user has been created")
        }
    }
}
