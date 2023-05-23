package id.ac.ibda.pads.proyekuas.Utils

import id.ac.ibda.pads.proyekuas.Model.CartItem

object ShoppingCart {
    private var items: MutableList<CartItem> = mutableListOf()

    fun addItem(item: CartItem) {
        items.add(item)
    }

    fun removeItem(item: CartItem) {
     items.remove(item)
    }

    fun clearCart() {
        items.clear()
    }

    fun getCartItems(): List<CartItem> {
        return items.toList()
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