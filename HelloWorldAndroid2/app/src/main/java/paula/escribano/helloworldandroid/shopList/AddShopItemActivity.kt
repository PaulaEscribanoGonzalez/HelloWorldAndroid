package paula.escribano.helloworldandroid.shopList

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import paula.escribano.helloworldandroid.R
import paula.escribano.helloworldandroid.shopList.ShopItem

class AddShopItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_shop_item)

        val nameEdit = findViewById<EditText>(R.id.nameItemEdit)
        val quantityEdit = findViewById<EditText>(R.id.quantityItemEdit)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val name = nameEdit.text.toString()
            val quantity = quantityEdit.text.toString().toIntOrNull() ?: 0

            val item = ShopItem(name, quantity)

            val intent = intent
            intent.putExtra("newItem", item)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}