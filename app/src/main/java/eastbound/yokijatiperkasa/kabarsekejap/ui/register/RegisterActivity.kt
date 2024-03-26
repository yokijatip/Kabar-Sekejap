package eastbound.yokijatiperkasa.kabarsekejap.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.databinding.ActivityRegisterBinding
import eastbound.yokijatiperkasa.kabarsekejap.ui.main.MainActivity
import eastbound.yokijatiperkasa.kabarsekejap.ui.onboarding.OnBoardingActivity
import eastbound.yokijatiperkasa.kabarsekejap.viewmodel.register.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]


        binding.apply {
            btnBack.setOnClickListener {
                startActivity(Intent(this@RegisterActivity, OnBoardingActivity::class.java))
                finish()
            }
            btnRegister.setOnClickListener {
                register()
            }
        }

    }

    private fun register() {
        binding.apply {
            val username = edtUsername.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

//            Check Form is empty or not
            when {
                email.isEmpty() && password.isEmpty() && username.isEmpty() -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        R.string.form_empty,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                username.isEmpty() -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        R.string.username_empty,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                email.isEmpty() -> {
                    Toast.makeText(this@RegisterActivity, R.string.email_empty, Toast.LENGTH_SHORT)
                        .show()
                }

                password.isEmpty() -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        R.string.password_empty,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                password.contains(" ") -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        R.string.password_contains_space,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                password.length < 5 -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        R.string.password_more_than_5,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    viewModel.register(username, email, password) {
                        if (it) {
                            Toast.makeText(this@RegisterActivity, "Registration Success✅", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@RegisterActivity, "Registration failed❌", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }
}