package eastbound.yokijatiperkasa.kabarsekejap.viewmodel.register

import androidx.lifecycle.ViewModel
import eastbound.yokijatiperkasa.kabarsekejap.data.repository.Repository

class RegisterViewModel : ViewModel() {

    private val repository = Repository()

    fun register(username: String, email: String, password: String, onComplete: (Boolean) -> Unit) {
        repository.registerUser(username, email, password, onComplete)
    }

}