package paula.escribano.helloworldandroid.shopList

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import paula.escribano.helloworldandroid.R

class QuantityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quantity)

        val item = intent.getParcelableExtra<ShopItem>("item")

        val foodText = findViewById<TextView>(R.id.foodText)
        val quantityText = findViewById<TextView>(R.id.quantityText)

        foodText.text = item?.name ?: "Unknown"
        quantityText.text = "Quantity: ${item?.quantity ?: 0}"
    }
}