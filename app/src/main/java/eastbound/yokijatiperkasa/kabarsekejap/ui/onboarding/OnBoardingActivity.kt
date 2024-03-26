package eastbound.yokijatiperkasa.kabarsekejap.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.databinding.ActivityOnBoardingBinding
import eastbound.yokijatiperkasa.kabarsekejap.ui.login.LoginActivity
import eastbound.yokijatiperkasa.kabarsekejap.ui.register.RegisterActivity

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            btnLogin.setOnClickListener {
                startLoginActivity()
            }

            btnRegister.setOnClickListener {
                startRegisterActivity()
            }
        }



    }

    private fun startLoginActivity() {
        startActivity(Intent(this@OnBoardingActivity, LoginActivity::class.java))
    }

    private fun startRegisterActivity() {
        startActivity(Intent(this@OnBoardingActivity, RegisterActivity::class.java))
    }
}