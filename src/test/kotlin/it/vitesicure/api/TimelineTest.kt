package it.vitesicure.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import it.vitesicure.plugins.configureRouting
import it.vitesicure.plugins.configureSerialization
import kotlin.test.Test
import kotlin.test.assertEquals

class TimelineShould {
    @Test
    fun `return 201 as status and created post as body when post a new message`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }

        client.post("/users/stubUserId/timeline") {
            contentType(ContentType.Application.Json)
            setBody("""{ "text": "Hello, I'm Alice" }""")
        }.apply {
            assertEquals(HttpStatusCode.Created, status)
            assertEquals("""
                {
                    "postId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
                    "userId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
                    "text": "Hello, I'm Alice",
                    "dateTime": "2018-01-10T11:30:00Z"
                }
            """.trimIndent(), bodyAsText().trimIndent())
        }
    }
}
