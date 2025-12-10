package paula.escribano.helloworldandroid.helloWorld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import paula.escribano.helloworldandroid.databinding.ActivityWelcomeBinding
import paula.escribano.helloworldandroid.R

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

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