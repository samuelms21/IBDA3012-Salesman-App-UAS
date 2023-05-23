package id.ac.ibda.pads.proyekuas.Adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ibda.pads.proyekuas.Model.ProductModel
import id.ac.ibda.pads.proyekuas.R

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var itemList: MutableList<ProductModel> = mutableListOf()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var productName: TextView
        var productPrice: TextView
        var productAvailableQty: TextView

        init {
            productName = itemView.findViewById(R.id.tvProductName)
            productPrice = itemView.findViewById(R.id.tvProductPrice)
            productAvailableQty = itemView.findViewById(R.id.tvProductAvailableQty)
        }

    }

    @SuppressLint("NotifyDataSetChanged")
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
        holder.productPrice.setText("$ ${currentItem.price.toString()}")
        holder.productAvailableQty.setText("Available Qty:\n${currentItem.available_qty.toString()}")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}