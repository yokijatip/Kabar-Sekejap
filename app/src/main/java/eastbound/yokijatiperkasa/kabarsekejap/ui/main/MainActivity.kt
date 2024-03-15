package eastbound.yokijatiperkasa.kabarsekejap.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Chat
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Message
import eastbound.yokijatiperkasa.kabarsekejap.data.model.User
import eastbound.yokijatiperkasa.kabarsekejap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Menambahkan pengguna baru
        val user = User(
            userId = "12345",
            username = "John Doe",
            email = "johndoe@gmail.com",
            profilePicture = "https://a.storyblok.com/f/191576/1200x800/215e59568f/round_profil_picture_after_.webp"
        )

        val userDatabaseReference = FirebaseDatabase.getInstance().getReference("users")
        userDatabaseReference.child(user.userId).setValue(user)

//        Menambahkan Room chat baru
        val chat = Chat(
            chatId = "chat123",
            participant = listOf("12345", "67890"),
            messages = listOf()
        )
        val chatDatabaseReference = FirebaseDatabase.getInstance().getReference("chats")
        chatDatabaseReference.child(chat.chatId).setValue(chat)

//        Menambahkan pesan baru
        val message = Message(
            messageId = "message456",
            senderId = "12345",
            receiverId = "67890",
            content = "Hello, how are you?",
            timestamp = System.currentTimeMillis()
        )

        val messageDatabaseReference = FirebaseDatabase.getInstance().getReference("chats")
        messageDatabaseReference.child(chat.chatId).child("messages").push().setValue(message)


    }
}