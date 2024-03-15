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
        get("/users/{userId}/timeline") {
            call.response.status(HttpStatusCode.OK)
            call.respond("""
                [
                    {
                        "postId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
                        "userId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
                        "text": "Hello, I'm Alice",
                        "dateTime": "2018-01-10T11:30:00Z"
                    }
                ]
            """)
        }
    }
}
