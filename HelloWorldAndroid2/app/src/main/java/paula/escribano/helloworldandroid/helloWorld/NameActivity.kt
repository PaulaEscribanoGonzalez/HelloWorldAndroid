package paula.escribano.helloworldandroid.helloWorld

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import paula.escribano.helloworldandroid.helloWorld.WelcomeActivity
import paula.escribano.helloworldandroid.databinding.ActivityNameBinding
import paula.escribano.helloworldandroid.R

class NameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botón DONE
        binding.doneButton.setOnClickListener {

            val name = binding.nameEditText.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, getString(R.string.empty_name_msg), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            // Navegar a WelcomeActivity enviando el nombre
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USERNAME", name)
            startActivity(intent)
        }

        // Habilitar botón atrás en el ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}