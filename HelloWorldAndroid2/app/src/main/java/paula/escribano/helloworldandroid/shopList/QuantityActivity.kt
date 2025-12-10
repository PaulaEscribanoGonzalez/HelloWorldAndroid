package paula.escribano.helloworldandroid.shopList

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import paula.escribano.helloworldandroid.R
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuantityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quantity)

        val root = findViewById<View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val item = intent.getParcelableExtra<ShopItem>("item")

        title = item?.name ?: getString(R.string.unknown)
        val foodText = findViewById<TextView>(R.id.foodText)
        val quantityText = findViewById<TextView>(R.id.quantityText)

        foodText.text = item?.name ?: getString(R.string.unknown)
        quantityText.text = getString(R.string.quantity_label, item?.quantity ?: 0)
    }
}