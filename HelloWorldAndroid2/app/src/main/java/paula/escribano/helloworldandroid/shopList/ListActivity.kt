package paula.escribano.helloworldandroid.shopList

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import paula.escribano.helloworldandroid.shopList.QuantityActivity
import paula.escribano.helloworldandroid.R
import paula.escribano.helloworldandroid.shopList.ShopItem
import paula.escribano.helloworldandroid.shopList.ShopListAdapter

class ListActivity : AppCompatActivity(), ShopListAdapter.ItemListener {

    private val shoppingList = mutableListOf(
        ShopItem("Pan", 1),
        ShopItem("Leche", 2),
        ShopItem("Huevos", 12),
        ShopItem("Queso", 1)
    )

    private lateinit var adapter: ShopListAdapter

    private val addItemLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val newItem = result.data?.getParcelableExtra<ShopItem>("newItem")
            if (newItem != null) {
                shoppingList.add(newItem)
                adapter.notifyItemInserted(shoppingList.size - 1)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ShopListAdapter(shoppingList, this)
        recyclerView.adapter = adapter

        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, AddShopItemActivity::class.java)
            addItemLauncher.launch(intent)
        }
    }

    override fun onItemClicked(item: ShopItem) {
        val intent = Intent(this, QuantityActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }
}