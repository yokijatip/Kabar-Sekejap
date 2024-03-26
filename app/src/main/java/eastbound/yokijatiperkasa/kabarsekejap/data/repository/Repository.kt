package eastbound.yokijatiperkasa.kabarsekejap.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import eastbound.yokijatiperkasa.kabarsekejap.data.model.User

class Repository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val rtDatabase: DatabaseReference =
        FirebaseDatabase.getInstance().reference.child("users")

    fun registerUser(
        username: String,
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val uid = auth.currentUser?.uid ?: ""
                    val user = User(uid, username, email)
                    rtDatabase.child(uid).setValue(user)
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
    }


    fun login(email: String, password: String, onComplete: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                onComplete(it.isSuccessful)
            }
    }

}