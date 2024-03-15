package it.vitesicure

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import it.vitesicure.plugins.*
import kotlinx.coroutines.runBlocking
import kotlin.test.*

class CustomerShould {
    private lateinit var testClient: HttpClient

    @Test
    fun `show his posts in the timeline`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        testClient = client
        `given a logged customer`()
        `and him post a message`()
        val response = `when see his timeline`()
        `then see message posted`(response)
    }

    private fun `given a logged customer`() {
//        TODO("Not yet implemented")
    }

    private fun `and him post a message`(): HttpResponse = runBlocking {
        testClient.post("/users/stubUserId/timeline") {
            contentType(ContentType.Application.Json)
            setBody("""{"text": "Hello, I'm Alice"}""")
        }.apply { assertEquals(HttpStatusCode.Created, status) }
    }

    private fun `when see his timeline`(): HttpResponse = runBlocking {
        testClient.get("/users/stubUserId/timeline").apply { assertEquals(HttpStatusCode.OK, status) }
    }

    private fun `then see message posted`(response: HttpResponse) = runBlocking {
        assertEquals("""
            [
                {
                    "postId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
                    "userId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
                    "text": "Hello, I'm Alice",
                    "dateTime": "2018-01-10T11:30:00Z"
                }
            ]
        """.trimIndent(), response.bodyAsText().trimIndent())
    }
}
