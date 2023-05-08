package com.example.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        trace { application.log.trace(it.buildText()) }
        route("/weather"){
            get("/usa"){
                call.respondText("The weather in US: snow")
            }
            route("/europe", HttpMethod.Get){
                header("systemtoken", "weathersystem") {
                    param("name") {
                        handle {
                            var name = call.parameters.get("name")
                            call.respondText { "Dear $name, the weather in Europe: sunny" }
                        }
                    }
                    handle {
                        call.respondText { "The weather in Europe: sunny" }
                    }
                }
            }
        }
    }
}
