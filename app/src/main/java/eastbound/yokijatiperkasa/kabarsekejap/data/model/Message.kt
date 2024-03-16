package eastbound.yokijatiperkasa.kabarsekejap.data.model

data class Message(
    val messageId: String,
    val senderId: String,
    val receiverId: String,
    val content: String,
    val timestamp: Long
)
