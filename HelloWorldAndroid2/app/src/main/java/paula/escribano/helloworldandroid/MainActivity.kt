package paula.escribano.helloworldandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import paula.escribano.helloworldandroid.birthday.BirthdayActivity
import paula.escribano.helloworldandroid.databinding.ActivityMainBinding
import paula.escribano.helloworldandroid.helloWorld.NameActivity
import paula.escribano.helloworldandroid.shopList.ListActivity
import paula.escribano.helloworldandroid.net.PostsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ponerlo en todas las activities!!!
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.helloWorldButton.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }


        binding.birthdayCardButton.setOnClickListener {
            val intent = Intent(this, BirthdayActivity::class.java)
            startActivity(intent)
        }

        binding.listButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        binding.netButton.setOnClickListener {
            val intent = Intent(this, PostsActivity::class.java)
            startActivity(intent)
        }
    }
}