package paula.escribano.helloworldandroid.shopList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import paula.escribano.helloworldandroid.R
import paula.escribano.helloworldandroid.shopList.ShopItem

class ShopListAdapter(
    private val items: List<ShopItem>,
    private val listener: ItemListener
) : RecyclerView.Adapter<ShopListAdapter.ShopViewHolder>() {

    interface ItemListener {
        fun onItemClicked(item: ShopItem)
    }

    inner class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textItem: TextView = itemView.findViewById(R.id.textItem)

        fun bind(item: ShopItem) {
            textItem.text = if (item.quantity > 0)
                "${item.name} (${item.quantity})"
            else
                item.name

            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop, parent, false)
        return ShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}