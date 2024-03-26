package eastbound.yokijatiperkasa.kabarsekejap

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


object Helper {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val rtDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()



}