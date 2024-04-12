package it.vitesicure

class TimelineService {
    fun create(userId: String, text: String): Post {
        return Post("postId",userId, text, "2018-01-10T11:30:00Z")
    }
}