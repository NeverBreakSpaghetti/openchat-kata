package it.vitesicure

import org.junit.Test
import kotlin.test.assertEquals


class TimelineServiceShould {
    @Test
    fun `return new created message in timeline`() {
        val timelineService = TimelineService()
        val userId = "uuidUser"
        val message = "messaggio"

        assertEquals(true ,
            timelineService.create(userId,message) ==
                    (Post("postId","uuidUser", "messaggio", "2018-01-10T11:30:00Z")))
    }
}