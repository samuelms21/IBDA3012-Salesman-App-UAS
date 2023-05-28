package id.ac.ibda.pads.proyekuas.Utils

import androidx.lifecycle.MutableLiveData
import id.ac.ibda.pads.proyekuas.Model.CartItem

object ShoppingCart {
    private var items: MutableLiveData<MutableList<CartItem>> = MutableLiveData(mutableListOf())

    fun addItem(item: CartItem) {
        if (items.value?.any{ it.productId == item.productId} == true) {
            val position = items.value?.indexOfFirst { it.productId == item.productId }
            items.value!![position!!].quantity += item.quantity
        } else {
            items.value!!.add(item)
        }
    }

    fun removeItem(item: CartItem) {
        items.value!!.remove(item)
    }

    fun clearCart() {
        items.value!!.clear()
    }

    fun getCartItems(): List<CartItem> {
        return items.value!!.toList()
    }

    fun getItemCount(): Int {
        return items.value!!.size
    }

    object companion {
        @Volatile
        private var instance: ShoppingCart? = null

        fun getInstance(): ShoppingCart {
            return instance ?: synchronized(this) {
                instance ?: ShoppingCart.also { instance = it }
            }
        }
    }
}