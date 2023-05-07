package learning.com.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        var weather = "sunny"
        get("/weatherforecast") {
            call.respondText(weather, contentType = ContentType.Text.Plain)
        }
        post("/weatherforecast") {
            weather = call.receiveText()
            call.respondText("Weather has been set to: $weather", contentType = ContentType.Text.Plain)
        }

    }
}
