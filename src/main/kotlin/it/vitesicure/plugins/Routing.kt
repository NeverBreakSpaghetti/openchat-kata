package it.vitesicure.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(mapOf(
                "Hello" to "World!",
                "Good" to "evening"
            ))
        }
    }
}
