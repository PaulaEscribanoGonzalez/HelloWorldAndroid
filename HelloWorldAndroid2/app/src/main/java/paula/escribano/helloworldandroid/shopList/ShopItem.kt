package paula.escribano.helloworldandroid.shopList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopItem(
    val name: String,
    val quantity: Int
) : Parcelable