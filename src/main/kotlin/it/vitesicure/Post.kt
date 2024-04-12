package it.vitesicure

class Post(postId: String, userId: String, text: String, creationDateTime: String) {
    val postId: String = postId
    val userId: String = userId
    val text: String = text
    val creationDateTime: String = creationDateTime

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Post) return false

        return this.postId == other.postId &&
                this.userId == other.userId &&
                this.text == other.text &&
                this.creationDateTime == other.creationDateTime
    }

    override fun hashCode(): Int {
        return postId.hashCode()
    }
}