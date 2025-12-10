package paula.escribano.helloworldandroid.helloWorld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import paula.escribano.helloworldandroid.databinding.ActivityWelcomeBinding
import paula.escribano.helloworldandroid.R
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recibir el nombre enviado desde NameActivity
        val name = intent.getStringExtra("USERNAME") ?: "User"

        // Mostrar mensaje personalizado
        binding.welcomeText.text = getString(R.string.welcome_message, name)

        // Activar botón atrás en el ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}