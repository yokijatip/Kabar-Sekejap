package eastbound.yokijatiperkasa.kabarsekejap.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import eastbound.yokijatiperkasa.kabarsekejap.Helper
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Chat
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Message
import eastbound.yokijatiperkasa.kabarsekejap.data.model.User
import eastbound.yokijatiperkasa.kabarsekejap.databinding.ActivityMainBinding
import eastbound.yokijatiperkasa.kabarsekejap.ui.main.contacts.ContactsFragment
import eastbound.yokijatiperkasa.kabarsekejap.ui.main.messages.MessagesFragment
import eastbound.yokijatiperkasa.kabarsekejap.ui.main.settings.SettingsFragment
import eastbound.yokijatiperkasa.kabarsekejap.ui.onboarding.OnBoardingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private fun fragmentManager(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.content, fragment, fragment.javaClass.simpleName)
        transaction.commit()
    }

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
        implementFragmentTransaction()

        binding.apply {

        }

//        Skema Realtime Database
////        Menambahkan pengguna baru
//        val user = User(
//            userId = "12345",
//            username = "John Doe",
//            email = "johndoe@gmail.com",
//            profilePicture = "https://a.storyblok.com/f/191576/1200x800/215e59568f/round_profil_picture_after_.webp"
//        )
//
//        val userDatabaseReference = FirebaseDatabase.getInstance().getReference("users")
//        userDatabaseReference.child(user.userId).setValue(user)
//
////        Menambahkan Room chat baru
//        val chat = Chat(
//            chatId = "chat123",
//            participant = listOf("12345", "67890"),
//            messages = listOf()
//        )
//        val chatDatabaseReference = FirebaseDatabase.getInstance().getReference("chats")
//        chatDatabaseReference.child(chat.chatId).setValue(chat)
//
////        Menambahkan pesan baru
//        val message = Message(
//            messageId = "message456",
//            senderId = "12345",
//            receiverId = "67890",
//            content = "Hello, how are you?",
//            timestamp = System.currentTimeMillis()
//        )
//
//        val messageDatabaseReference = FirebaseDatabase.getInstance().getReference("chats")
//        messageDatabaseReference.child(chat.chatId).child("messages").push().setValue(message)






    }

    private fun implementFragmentTransaction(){
        binding.apply {
            bottomNav.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
                override fun onItemSelected(id: Int) {
                    when(id) {
                        R.id.nav_messages -> {
                            val fragment = MessagesFragment.newInstance()
                            fragmentManager(fragment)
                        }
                        R.id.nav_contacts -> {
                            val fragment = ContactsFragment.newInstance()
                            fragmentManager(fragment)
                        }
                        R.id.nav_settings -> {
                            val fragment = SettingsFragment.newInstance()
                            fragmentManager(fragment)
                        }
                    }
                }
            })
        }
        fragmentManager(MessagesFragment.newInstance())
        binding.bottomNav.setItemSelected(R.id.nav_messages)
    }


    private fun logout() {
        Helper.auth.signOut()
        startActivity(Intent(this@MainActivity, OnBoardingActivity::class.java))
        finish()
    }

    private fun handleBackButton() {
        
    }
}