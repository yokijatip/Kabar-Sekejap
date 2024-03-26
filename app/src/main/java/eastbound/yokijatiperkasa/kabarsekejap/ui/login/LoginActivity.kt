package eastbound.yokijatiperkasa.kabarsekejap.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.databinding.ActivityLoginBinding
import eastbound.yokijatiperkasa.kabarsekejap.ui.main.MainActivity
import eastbound.yokijatiperkasa.kabarsekejap.ui.onboarding.OnBoardingActivity
import eastbound.yokijatiperkasa.kabarsekejap.viewmodel.login.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.apply {
            btnBack.setOnClickListener {
                finish()
            }
            btnLogin.setOnClickListener {
                login()
            }
        }



    }

    private fun login() {
        binding.apply {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            when {
                email.isEmpty() && password.isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "Email and Password is empty", Toast.LENGTH_SHORT).show()
                }
                email.isEmpty() -> {
                    Toast.makeText(this@LoginActivity, R.string.email_empty, Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(this@LoginActivity, R.string.password_empty, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    viewModel.login(email, password) {
                        if (it) {
                            Toast.makeText(this@LoginActivity, "Login successful✅", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, "Login failed❌", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }
}