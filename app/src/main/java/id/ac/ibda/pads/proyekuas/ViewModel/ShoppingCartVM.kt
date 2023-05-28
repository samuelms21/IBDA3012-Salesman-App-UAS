package id.ac.ibda.pads.proyekuas.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import id.ac.ibda.pads.proyekuas.Model.CartItem
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject
import id.ac.ibda.pads.proyekuas.Utils.ShoppingCart

class ShoppingCartVM: ViewModel() {
    private val apiService = RetrofitObject.apiService

    fun getCartItems(): List<CartItem> {
        val allCartItems: List<CartItem> = ShoppingCart.getCartItems()
        return allCartItems
    }

    fun getCartItemCount(): Int {
        return ShoppingCart.getItemCount()
    }

    fun getCartTotalPrice(): Double {
        var total: Double = 0.0
        for (item in getCartItems()) {
            total = total + (item.price * item.quantity)
        }
        return total
    }

    fun clearCart() {
        ShoppingCart.clearCart()
    }
}