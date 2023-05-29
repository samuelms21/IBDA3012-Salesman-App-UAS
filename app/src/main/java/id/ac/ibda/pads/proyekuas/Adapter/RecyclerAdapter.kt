package id.ac.ibda.pads.proyekuas.Adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ibda.pads.proyekuas.Model.ProductModel
import id.ac.ibda.pads.proyekuas.R

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    interface ItemButtonClickListener {
        fun onItemButtonClicked(position: Int, qty: Int, product: ProductModel)
    }

    private var itemList: MutableList<ProductModel> = mutableListOf()
    private var itemButtonClickListener: ItemButtonClickListener? = null

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var productName: TextView
        var productPrice: TextView
        var productAvailableQty: TextView
        var addToCartButton: Button
        var productQtyInput: EditText

        init {
            productName = itemView.findViewById(R.id.tvProductName)
            productPrice = itemView.findViewById(R.id.tvProductPrice)
            productAvailableQty = itemView.findViewById(R.id.tvProductAvailableQty)
            addToCartButton = itemView.findViewById(R.id.addToCartButton)
            productQtyInput = itemView.findViewById(R.id.productQtyInput)
        }

    }

    fun setItemButtonClickListener(listener: ItemButtonClickListener) {
        itemButtonClickListener = listener
    }

    fun updateDataList(newItemList: MutableList<ProductModel>) {
        itemList = newItemList
        Log.d("RECYCLER_ADAPTER", itemList.toString())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val currentItem = itemList.get(position)
        // Update the view with the data from currentItem
        holder.productName.text = currentItem.name
        holder.productPrice.setText("$ ${currentItem.price}")
        holder.productAvailableQty.setText("Available Qty:\n${currentItem.available_qty.toString()}")

        holder.addToCartButton.setOnClickListener {
            if (holder.productQtyInput.text.toString().isEmpty()) {
                // pass
            } else {
                val qty = holder.productQtyInput.text.toString().trim().toInt()  // ini error kalau kososng
                itemButtonClickListener?.onItemButtonClicked(position, qty, currentItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}