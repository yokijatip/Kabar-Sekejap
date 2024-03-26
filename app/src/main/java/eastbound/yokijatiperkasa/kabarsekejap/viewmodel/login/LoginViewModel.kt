package eastbound.yokijatiperkasa.kabarsekejap.viewmodel.login

import androidx.lifecycle.ViewModel
import eastbound.yokijatiperkasa.kabarsekejap.data.repository.Repository

class LoginViewModel : ViewModel() {

    private val repository = Repository()

    fun login(email: String, password: String, onComplete: (Boolean) -> Unit) {
        repository.login(email, password, onComplete)
    }

}