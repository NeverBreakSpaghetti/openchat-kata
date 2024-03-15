package it.vitesicure.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        post("/users/{userId}/timeline") {
            call.respond(HttpStatusCode.Created)
        }
    }
}
