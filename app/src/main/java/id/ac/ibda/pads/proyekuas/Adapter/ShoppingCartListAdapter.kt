package id.ac.ibda.pads.proyekuas.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ibda.pads.proyekuas.Model.CartItem
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.Utils.ShoppingCart

class ShoppingCartListAdapter: RecyclerView.Adapter<ShoppingCartListAdapter.ViewHolder>() {

    private var cartItems: List<CartItem> = ShoppingCart.getCartItems()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var shoppingCartItemName: TextView
        var shoppingCartItemQty: TextView
        var shoppingCartItemPrice: TextView

        init {
            shoppingCartItemName = itemView.findViewById(R.id.shoppingCartItemName)
            shoppingCartItemQty = itemView.findViewById(R.id.shoppingCartItemQty)
            shoppingCartItemPrice = itemView.findViewById(R.id.shoppingCartItemPrice)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingCartListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.shopping_cart_item_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ShoppingCartListAdapter.ViewHolder, position: Int) {
        // Populate Our Data
        val currentItem = cartItems[position]
        holder.shoppingCartItemName.text = currentItem.productName
        holder.shoppingCartItemQty.text = "${currentItem.quantity}x"

        val productSubtotal = currentItem.price * currentItem.quantity
        holder.shoppingCartItemPrice.text = "$ ${productSubtotal}"
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}