package eastbound.yokijatiperkasa.kabarsekejap.data.model

data class Chat(
    val chatId: String,
    val participant: List<String>,
    val messages: List<Message>
)
